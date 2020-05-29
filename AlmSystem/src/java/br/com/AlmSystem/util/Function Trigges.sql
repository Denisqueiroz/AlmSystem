
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
---essa function funciona somenbte de exmplo
create  or REPLACE  FUNCTION iserir_saldo() 
returns trigger  AS $$

BEGIN

  UPDATE item  set quantidade = quantidade + saldo
  from estoque
  where estoque.id_item = item.id_item  ;
  end ;
$$ LANGUAGE plpgsql;


-----------FUNCTION-------------------

DROP FUNCTION retirar_quantidade(INTEGER, INTEGER);

create  or REPLACE  FUNCTION retirar_quantidade(id integer, quant integer) 
returns text  AS $$
BEGIN
  UPDATE item  set quantidade = quantidade - quant  where id_item = id  ;
     return null ;
end ;
$$ LANGUAGE plpgsql;

--------FUNCTION COM  IF ELS
create  or REPLACE  FUNCTION retirar_quantidade(id integer, quant integer, operacao integer) 
returns text  AS $$
BEGIN
 if operacao = 1 then
   UPDATE item  set quantidade = quantidade - quant  where id_item = id  ;
  return null ;
	 elsif  operacao = 2 then
  UPDATE item  set quantidade = quantidade + quant  where id_item = id  ;
  return null ;	 
	end if ; 
end ;
$$ LANGUAGE plpgsql;

 ----------------trigger--------------
create trigger retirar_quantidade
before update
on item
for each row when(pg_trigger_depth()= 0)
execute procedure retirar_quantidade()  