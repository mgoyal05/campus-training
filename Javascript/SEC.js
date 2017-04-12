var elem = document.getElementById("canvas");//selecting element by id
var points = [];
var rect = canvas.getBoundingClientRect();//getting width, height and other parameters according to their coordinates
console.log(rect);
var C = {x:0,y:0,r:0};
var MULTIPLICATIVE_EPSILON = 1 + 1e-14;

elem.addEventListener('click',(function(e){
     getPosition(e); 
})
,false);

function getPosition(event){	
	var x = event.clientX - rect.left;
	var y = event.clientY - rect.top;
	var ctr = false;             console.log(x + " and y" + y + " and ctr " + ctr + " length of point array = "+ points.length);
	var i=0;
	while(points.length>0&&i<points.length&&ctr===false){//in case i exceeds length of point array 
        if((points[i].x >= (0.99*x) && points[i].x <= (1.01*x)) || (points[i].y >= (0.99*y) && points[i].y <= (1.01*y))){ // will remove point if found within this range
			drawCoordinates(x,y,"white",40);
			ctr=true;            console.log("hare " + i);
		    points.splice(i,1); // remove point in array
		}
		else{ 
			i++;
            console.log("Else part is FUNCT " + points.length);
        }
	}
	if(ctr===false){
		drawCoordinates(x,y,"brown",3);
		points.push({x:x,y:y});   console.log(points[i].x + "  -> brown "+ C.x);
		ctr=false;
	}
	
	drawCircle(C.x,C.y,C.r,"white",6);//to remove previous circle drawn
	console.log("BEFORE using makepoint function " + C.r);
	C = makeCircle(points);
	console.log("After using makepoint function " + C.r);
	drawCircle(C.x,C.y,C.r,"red",3);
	drawPoints(points, 'brown');
}

function makeCircle(points) {
	var shuffled = points.slice();// making a new list and copying the data
    console.log("value of shuffeled " + shuffled.length);
	for (var i = points.length - 1; i >= 0; i--) {// shuffle the data in the new list
		var j = Math.floor(Math.random() * (i + 1));
		j = Math.max(Math.min(j, i), 0);
		var temp = shuffled[i];
		shuffled[i] = shuffled[j];
		shuffled[j] = temp;
	}
	
	var c = null;
	for (var i = 0; i < shuffled.length; i++) {
		var p = shuffled[i];
		if (c == null || !isInCircle(c, p))
			c = makeCircleOnePoint(shuffled.slice(0, i + 1), p);//points till a[i]
	}
	
	return c;
}


function makeCircleOnePoint(points, p) {
	var c = {x: p.x, y: p.y, r: 0};
	for (var i = 0; i < points.length; i++) {
		var q = points[i];
		if (!isInCircle(c, q)) { // if q is not there in circle c
			if (c.r == 0)
				c = makeDiameter(p, q); // return circle with diameter as distance of p-q
			else
				c = makeCircleTwoPoints(points.slice(0, i + 1), p, q);
		}
	}
	return c;
}


// Two boundary points known
function makeCircleTwoPoints(points, p, q) {
	var circ = makeDiameter(p, q);
	var left = null;
	var right = null;
	
	// For each point not in the two-point circle
	points.forEach(function(r) { // calls function(r) once for each element in points
		if (isInCircle(circ, r))
			return;
		
		// Form a circumcircle and classify it on left or right side
		var cross = crossProduct(p.x, p.y, q.x, q.y, r.x, r.y); console.log("circumcircle " + p.x + "  " + r.x);
		var c = makeCircumcircle(p, q, r);
		console.log(c);
		if (c == null)
			return;
		else if (cross > 0 && (left == null || crossProduct(p.x, p.y, q.x, q.y, c.x, c.y) > crossProduct(p.x, p.y, q.x, q.y, left.x, left.y)))
			left = c;
		else if (cross < 0 && (right == null || crossProduct(p.x, p.y, q.x, q.y, c.x, c.y) < crossProduct(p.x, p.y, q.x, q.y, right.x, right.y)))
			right = c;
		console.log(r.x);
	});
	
	// Select which circle to return
	if (left == null && right == null)
		return circ;
	else if (left == null)
		return right;
	else if (right == null)
		return left;
	else
		return left.r <= right.r ? left : right;
}


function makeCircumcircle(p0, p1, p2) {
	// Mathematical algorithm from Wikipedia: Circumscribed circle
	var ax = p0.x, ay = p0.y;
	var bx = p1.x, by = p1.y;
	var cx = p2.x, cy = p2.y;
	var ox = (Math.min(ax, bx, cx) + Math.max(ax, bx, cx)) / 2;//making centroid
	var oy = (Math.min(ay, by, cy) + Math.max(ay, by, cy)) / 2;
	ax -= ox; ay -= oy;
	bx -= ox; by -= oy;
	cx -= ox; cy -= oy;
	var d = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) * 2;
	if (d == 0)
		return null;
	var x = ox + ((ax * ax + ay * ay) * (by - cy) + (bx * bx + by * by) * (cy - ay) + (cx * cx + cy * cy) * (ay - by)) / d;
	var y = oy + ((ax * ax + ay * ay) * (cx - bx) + (bx * bx + by * by) * (ax - cx) + (cx * cx + cy * cy) * (bx - ax)) / d;
	var ra = distance(x, y, p0.x, p0.y);
	var rb = distance(x, y, p1.x, p1.y);
	var rc = distance(x, y, p2.x, p2.y);
	// console.log(p0,p1,p2);
	return {x: x, y: y, r: Math.max(ra, rb, rc)};
}


function makeDiameter(p0, p1) {
	var x = (p0.x + p1.x) / 2;
	var y = (p0.y + p1.y) / 2;
	var r0 = distance(x, y, p0.x, p0.y);
	var r1 = distance(x, y, p1.x, p1.y);
	// console.log(p0,p1);
	return {x: x, y: y, r: Math.max(r0, r1)};
}

function isInCircle(c, p) {
	return c != null && distance(p.x, p.y, c.x, c.y) <= c.r * MULTIPLICATIVE_EPSILON;
}

function crossProduct(x0, y0, x1, y1, x2, y2) {
	return (x1 - x0) * (y2 - y0) - (y1 - y0) * (x2 - x0);
}

function distance(x1,y1,x2,y2){
	return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
}

function drawPoints(points, color){
	for(var i=0;i<points.length;i++)
		drawCoordinates(points[i].x,points[i].y,color,3);
}

function drawCoordinates(x,y,color,size){
    var pointSize = size;
    var ctx = document.getElementById("canvas").getContext("2d");
    ctx.fillStyle = color;
    ctx.beginPath();
    ctx.arc(x, y, pointSize, 0, Math.PI * 2, true);
    ctx.fill(); 
}

function drawCircle(x,y,r,color,stroke){
	var ctx = document.getElementById("canvas").getContext("2d");
	ctx.lineWidth = stroke;
	ctx.strokeStyle = color;
	ctx.beginPath();
	ctx.arc(x,y,r,0,Math.PI*2);
	ctx.stroke();
}
