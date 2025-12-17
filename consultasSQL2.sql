INSERT INTO devices (name, category, price, stock) VALUES (?, ?, ?, ?);
DELETE FROM devices WHERE id = ?;
SELECT * FROM devices WHERE category = ?;
SELECT d.name, AVG(r.rating) as media_rating FROM devices d LEFT JOIN reviews r ON d.id = r.device_id GROUP BY d.id, d.name HAVING media_rating IS NOT NULL;
SELECT SUM(stock) as total_stock FROM devices;
SELECT name, price FROM devices ORDER BY price DESC;   