{
   TP1Ej2v2.pas
   
   @autor: Germán Martínez
   
   Problema:

   Diseñar un programa que devuelva el representante normalizado de
   un numero dado en base 10 , expresado en una base B con 2 <= B < 10.
   * 12 digitos para la mantisa.
   * 7 digitos para la mantisa.
   
   
   Este programa trabaja con cadenas de caracteres
}


program TP1Ej2v2;

uses sysutils,crt;

// Funcion que devuelve la parte entera de un numero en base 10
function obtenerEntera (numero : string): string;
var
	i : integer;
	bandera : boolean;
begin
	obtenerEntera := '';
	
	i := 1;
	bandera := false;
	
	while ( (i <= length(numero)) and (not bandera) ) do
		begin
			if (numero[i] <> '.') then
				begin
					obtenerEntera := obtenerEntera + numero[i];
				end
			else
				begin
					bandera := true;
					if (i = 1) then
						obtenerEntera := '0'
				end;
			i := i + 1;
		end;
end;
// Fin funcion obtenerEntera

// Funcion que devuelve la parte fraccionaria de un numero en base 10
function obtenerFraccionaria(numero : string): string;
var
	i : integer;
	bandera : boolean;
begin
	obtenerFraccionaria := '0,';
	
	i := 1;
	bandera := false;
	
	while ( (i <= length(numero)) and (not bandera) ) do
		begin
			if (numero[i] = '.') then
				begin
					bandera := true;
				end;
				i := i + 1;
		end;
	
	while (i <= length(numero)) do
		begin
			obtenerFraccionaria := obtenerFraccionaria + numero[i];
			i := i + 1;
		end;
end;
// Fin funcion obtenerEntera

// Funcion que convierte la parte entera a la base B
function convertirEntera( snumero : string; base : byte): string;
var
	digito : byte;
	cod : integer;
	inumero : longint;
	aux : string;
begin
	val( snumero, inumero, cod);
	
	if (length(snumero) = 0) or (inumero = 0) then
		convertirEntera := '0'
	else
		convertirEntera := '';
		
	while ( inumero <> 0 ) do
		begin
			digito := inumero mod base;
			inumero := inumero div base;
			str(digito, aux);
			convertirEntera := aux + convertirEntera;
		end;
end;
// Fin funcion convertirEntera

// Funcion que convierte la parte fraccionaria a la base B
function convertirFraccionaria( snumero : string; base : byte): string;
var
	cod, cont : integer;
	dnumero, digito : real;
	aux : string;
begin
	dnumero := strtofloat(snumero);
	if (length(snumero) = 0) or (dnumero = 0.0) then
		convertirFraccionaria := '0'
	else
		convertirFraccionaria := '';
		
	cont := 1;
	while ( (dnumero <> 0.0) and (cont <= 15) ) do
		begin
			digito := int(dnumero * base);
			dnumero := frac(dnumero * base);
			str(digito:1:0, aux);
			convertirFraccionaria := convertirFraccionaria + aux;
			cont := cont + 1;
		end;
end;
// Fin funcion convertirFraccionaria


// Programa principal
var
	numOriginal, parteEntera, parteFraccionaria : string;
	parteEnteraConv, parteFracConv, numConvertido : string;
	base : byte;

BEGIN
	numOriginal := '123546.11346';
	base := 8;
	
	write('Ingrese un numero en base 10 (puede ser real): ');
	readln(numOriginal);
	repeat
		write('Ingrese la base a la que quiere convertir (base entre 2 y 9): ');
		readln(base);
	until( (base >= 2) and (base < 10) );
	
	parteEntera := obtenerEntera( numOriginal );
	parteFraccionaria := obtenerFraccionaria( numOriginal );
	parteEnteraConv := convertirEntera( parteEntera, base );
	parteFracConv := convertirFraccionaria( parteFraccionaria, base );
	numConvertido := parteEnteraConv + '.' + parteFracConv;
		
	writeln();
	writeln('Numero Original en base 10: ', numOriginal);
	writeln();
	writeln('Numero Convertido a base ', base,': ', numConvertido);
	writeln();
	writeln();
END.

