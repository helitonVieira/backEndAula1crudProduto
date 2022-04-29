configuração banco de dados docs.oracle.com 
COMANDOS SQL*PLUS
	set lines  /*quantidade de linhas*/
	set pages /*qtd de paginas*/
	
	ed /*abrir bloco de notas   / tras de volta arquivo alterado */
	ed teste1 /*  criado o arquivo nome texte1*/
	@teste1 /*execulta o aruqivo */
	save teste2 /*salvar arquivo*/
	save teste2 replace /*alterar o arquivo*/
	spool caminho /*inicia a gravação em buf salvar em um arquivo texto*/
	spool off /*finaliza a gravação*/
	
******************************************************
desc escala_tissa /*busca todos os campos da tabela com tipos*/

1)insert into nome_tabela (campo1,campo2)values (1,2);
2)insert into nome_tabela select * from nome_tabela where restriçoes;
3)insert into  nome_tabela (campo1,campo2)select campo1,campo2 from nome_tabela where restriçoes;

update nome_tabela set campo1 = 1 , campo2 ='testes' 

delete from nome_tabela where campo = 123 

truncate table nome_tabela; /*exclui definitivamente*/

select  rownum /*(retorna numero da linha )*/,
        count(*),
where dt_emissao = sysdate 
and rownum < 10
and lower(nome) like lower('%heliton%')  /*upper*/
group by
having 
order by nome desc
******************************************************

create table nome_tabela (campo int , campo varchar);
create table nome_tabela  as select * from nome_tabela2;
create table nome_tabela  as select campo1, campo2 from nome_tabela2 where restrições;

alter table nome_tabela add (campo int , campo varchar);
alter table nome_tabela drop column nome_campo;
alter table nome_tabela modify (nome_campo number(20) not null);
drop table nome_tabela;

*********************** procedure *******************************
create or replace
procedure Nome_Procedure(nm_usuario_p	Varchar2) is  /*utiliza o out quando quer pegar o retorno de uma variavel   ex:  (nm_usuario_p out Varchar2 )*/
qt_registro_w number(10);
qt_registro1_w number(10) = 2 ;/*atribuindo valor*/
/*procedure ate o begin são as variaveis */
begin 

commit;

end Nome_Procedure;
/

-----------------------------------------FUNCTION-----------------------------------------------
/*funciona igual a procedure mais é obrigado ter um retorno*/
create or replace
function Nome_Funcao(ds_parametro		tipo_parametro)
 		    	return tipo_retorno is
/*as variaveis */			
begin


return	variavel_retorno; 

end Nome_Funcao;
/
-------------------------------------------------package------------------------------------------------------
/*para executar varias procedures function tudo ao msm tempo */
/*ela tem 2 parte 1 de declaração 2 com corpo manipulando os objetos*/

create or replace package body nome_package as 
 
	procedure  soma (campo1 number(10),campo2 number(10)); 
	procedure divisao(campo1 number(10),campo2 number(10));
	function  subtracao(campo1 number(10),campo2 number(10));
end nome_package;

/*corpo do pacote*/
create or replace package body  nome_package as 
/*variaveis globais */
 qt_registro number(10);
 m_pessoa_fisica_w pessoa_fisica.nm_pessoa_fisica%type /*atribuindo o tipo conforme da tabela pessoa_fisica*/
	procedure  soma (campo1 number(10),campo2 number(10)) is
	  begin
		/*codigo*/
	end soma; 	
	procedure divisao(campo1 number(10),campo2 number(10))is
	  begin
		/*codigo*/
	end divisao;
	function  fk_subtracao(campo1 number(10),campo2 number(10))is
	  begin
		/*codigo*/
	end fk_subtracao;
end nome_package;	

--------------------------------------------trigger -----------------------------------------------------------
/*disparo para um insert update delete*/
create or replace trigger nome_trigger
before insert or update on nome_tabela
for each row

declare
  /*onde vai ser informado as variaveis  cursores */
begin
  /*codigo fonte aqui*/
end;
/

------------------------------------------------view--------------------------------------------------------------------
/*é um select com varias tabelas ou uma modificada */
create or replace view	nome_view /*nome_view_v*/
as 
 select codPessoa, nomPessoa,codCidade,nomCidade
 from tab_pessoa a
 join tab_cidade b on (a.codCidade = b.codCidade)
 where b.codEstado = 3
 
------------------------------------------------job------------------------------------------------------------------ 
/*serviços que vai ser executados de tempos em tempos*/
variable jobno number;
begin 
	dbms_job.submit(:jobno,                    --parametro com codigo job obrigatorio
			'procedure(parametro);'    --procedure parametro OQUE VAI SER EXECUTADO NESTA JOB
			sysdate,                   --primeira execussão 
			'trunc(sysdate + 1) 03/24' --INTERVALO proxima execução no caso aqui todo dia as 3 da manha
			);
end; /

------------------------------------------------sequence------------------------------------------------
/*objeto banco retorna numeros sequenciais */
create sequence nome_sequence /*nomeTabela_seq*/
	increment by 1    
	start with 1000    
	maxvalue 99999999999999999  
        nocache 


exec nome_procedure; /* executar a procedure*/
drop procedure nome_procedure;
drop function nome_function;

-----------------------------------------------debug procedure e function oracle -----------------------------------------------

1)  Raise_application_error(-20011,'#@#@'); /*-20011,'#@#@'  -20011 padrao depois as variaveis que quer apresentar*/

2)  set serveroutput on ;
    bdms_output.put_line('texto  a apresentar no console');
    set serveroutput off; 
    
 3) create table minha_tabela_temp (ds varchar2(4000));
    insert into minha_tabela_temp values('minha linha debug'); 
    commit; -- caso nescessário
----------------------------------------------- -----------------------------------------------

