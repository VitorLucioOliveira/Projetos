SELECT Cliente.id_cliente, COUNT(Compra.id_compra) AS quantidade_compras
FROM Cliente
JOIN Foto ON Cliente.id_cliente = Foto.id_cliente
JOIN Compra ON Cliente.id_cliente = Compra.id_cliente
WHERE Foto.ordem_foto = 1
GROUP BY Cliente.id_cliente;