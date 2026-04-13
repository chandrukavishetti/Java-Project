use organization;

-- List all countries along with their region names.
SELECT 
    c.country_name, r.region_name
FROM
    countries c
        INNER JOIN
    regions r ON r.region_id = c.region_id;

-- List all locations along with their country names.
SELECT 
    l.street_address, c.country_name
FROM
    locations l
        INNER JOIN
    countries c ON c.country_id = c.country_id;

-- Find all regions, including those without any countries.
SELECT 
    r.region_name, c.country_name
FROM
    regions r
        LEFT JOIN
    countries c ON r.region_id = c.region_id;

-- Find all countries, including those without any locations.
SELECT 
    c.country_name, r.region_name
FROM
    countries c
        LEFT JOIN
    regions r ON r.region_id = c.region_id;
    
-- Get the count of countries in each region.
SELECT 
    r.region_name, COUNT(country_id) country_count
FROM
    regions r
        LEFT JOIN
    countries c ON r.region_id = c.region_id
GROUP BY region_name;

-- Get the count of locations in each country.
SELECT 
    c.country_name, COUNT(location_id) location_count
FROM
    locations l
        LEFT JOIN
    countries c ON c.country_id = l.country_id
GROUP BY country_name;

-- List regions that have more than 5 countries.
SELECT 
    r.region_name, COUNT(country_id) country_count
FROM
    regions r
        LEFT JOIN
    countries c ON c.region_id = r.region_id
GROUP BY region_name
HAVING COUNT(*) > 5;

-- Find all cities with their country and region names.
SELECT 
    l.city, c.country_name, r.region_name
FROM
    locations l
        JOIN
    countries c ON l.country_id = c.country_id
        JOIN
    regions r ON c.region_id = r.region_id;

-- List all countries that do not have any locations.
-- List the region name, country name, and the number of locations per country.
--  
--  
--  
-- Which countries are located in the "Asia" region?
-- List the names of all countries in the "Americas" region that have at least one location.
-- Find all cities in the "Europe" region along with their respective country names.
-- How many countries are in the "Middle East and Asia" region?
-- List all regions along with the number of countries in each region.
-- Which countries do not have any associated locations?
-- Find all countries along with their region names, where the region name is either "Europe" or "Asia".
-- List all locations in "Italy" along with the city and postal code.
-- Which countries have more than one location?
-- Retrieve all locations in "Canada" and the United States along with the state/province information.