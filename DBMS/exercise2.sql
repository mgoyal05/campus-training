
select accidents.States, round((accidents.`2011`/population.Population),7) as _2011PerCapita
from accidents join population on accidents.States = population.Region
where accidents.`2011` is not null order by _2011PerCapita desc limit 3 ;
