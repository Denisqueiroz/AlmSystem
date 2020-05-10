
---------function inserir data----------------------------
create  or REPLACE FUNCTION data_entrada()
returns trigger  AS $$
BEGIN
   New.data_entrada = now();
   return new ;

 END ;
$$ LANGUAGE plpgsql;
-----------trigges-------------------
create trigger data_cadastro_item
before insert 
on item
for each row
execute procedure data_entrada() ;


-----function movimentação de estoque--------------

create  or REPLACE  FUNCTION iserir_saldo() 
returns trigger  AS $$

BEGIN

  UPDATE item  set quantidade = quantidade + saldo
  from estoque
  where estoque.id_item = item.id_item  ;

$$ LANGUAGE plpgsql;


-----------trigges-------------------

create trigger iserir_saldos
before insert 
on item
for each row
execute procedure iserir_saldo() ;

