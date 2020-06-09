
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
execute procedure retirar_quantidade()  ;


-------------trigger e function  horas ------------------

create  or REPLACE FUNCTION data_movimentacao()
returns trigger  AS $$
BEGIN
   New.data_movimentacao = now();
   return new ;

 END ;
$$ LANGUAGE plpgsql;

create trigger data_movimentacao_item
before insert 
on movimentacao
for each row
execute procedure data_movimentacao() ;
------------Function para insert  na tabela movimentação relatorio-------------------------------------------

create  or REPLACE  FUNCTION retirar_quantidade(id integer, quant integer, operacao integer) 
returns text  AS $$

BEGIN
    if operacao = 1 then
   UPDATE item  set quantidade = quantidade - quant  where id_item = id  ;
   INSERT INTO movimentacao( quantidade, id_item,opera) VALUES ( quant, id,'Saida');   
  return null ;
     elsif  operacao = 2 then
     UPDATE item  set quantidade = quantidade + quant  where id_item = id  ; 
    INSERT INTO movimentacao( quantidade, id_item, opera) VALUES ( quant, id,'Estorno'); 
  
   
  return null ;  
    end if ; 

    end ;
$$ LANGUAGE plpgsql;
DROP FUNCTION retirar_quantidade(INTEGER, INTEGER, INTEGER);