{
   RepSimetrico.pas
   
   @autor: Germán Martínez
   
   Problema:

   Diseñar un programa que devuelva el representante simétrico redondeado
   a t dígitos significativos (t como parametro) en base 10, para 
   cualquier real dado en base 10.
}


program RepSimetrico;

uses crt, math;

// Funcion que devuelve la parte entera de un numero en base 10
function redondear (numero : double; t : byte; neg : boolean): string;
var
	exp : longint;
	aux : double;
	mantisa, sexp : string;
begin
	redondear := '0';
	
	exp := floor(ln(numero)/ln(10)) + 1;
	
	aux := numero * power(10.0, -exp);
	aux := aux + ( 0.5 * power(10.0, -t) );
	aux := aux * power(10.0, t);
	aux := trunc(aux);
	aux := aux * power(10.0, -t);
	
	str(aux:t:t, mantisa);
	str(exp, sexp);
	
	redondear := mantisa + ' x 10 ^ ' + sexp;
	
	if (neg) then
		redondear := '-' + redondear;
end;
// Fin funcion redondear

// Programa principal
var
	numOriginal, aux : double;
	representante : string;
	t : byte;
	negativo : boolean;
BEGIN	
	write('Ingrese un numero en base 10 (puede ser real): ');
	readln(numOriginal);
	repeat
		write('Ingrese cantidad de digitos significativos (entre 1 y 20): ');
		readln(t);
	until( (t>1) and (t < 20) );

	if (numOriginal < 0.0) then
		begin
			aux := -numOriginal;
			negativo := true;
		end
	else
		begin
			aux := numOriginal;
			negativo := false;
		end;
	
	representante := redondear(aux, t, negativo);
		
	clrscr();
	writeln();
	writeln('Numero Original en base 10: ', numOriginal:20:20);
	writeln();
	writeln('Representante simetrico a ', t,' digitos significativos: ', representante);
	writeln();
	writeln();
END.

