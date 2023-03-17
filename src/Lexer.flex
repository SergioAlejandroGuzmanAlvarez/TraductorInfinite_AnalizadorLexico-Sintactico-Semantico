import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }

%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "!!" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
A=[!¡,]
Identificador = {Letra}({Letra}|{Digito})*
P=[.]
/* Número */
Numero = 0 | [1-9][0-9]*
N=[0-9]*
%%






/* Comentarios o espacios en blanco */
{Comentario}|{EspacioEnBlanco} { /*Ignorar*/ }
/* ------------------------------------------------------------ */
/* IDENTIFICADOR*/
@{Identificador} { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn); }
/* TIPOS DE DATO */

'({Letra}|{Digito}|{EspacioEnBlanco})*' {return token(yytext(), "CADENA", yyline, yycolumn); }

str { return token(yytext(), "TIPO_DE_DATO_CADENA", yyline, yycolumn); }
int { return token(yytext(), "TIPO_DE_DATO_ENTERO", yyline, yycolumn); }
dec { return token(yytext(), "TIPO_DE_DATO_DECIMAL", yyline, yycolumn); } 
bool { return token(yytext(), "TIPO_DE_DATO_BOOLEANO", yyline, yycolumn); }

/* NUMERO*/
 0 | [1-9][0-9]* { return token(yytext(), "NUMERO", yyline, yycolumn); }

{Numero}.[0]*{Numero} { return token(yytext(), "NUMERO_DECIMAL", yyline, yycolumn); }
/*COLORES*/
BLANCO |
GRISCLARO |
GRIS |
NEGRO |
ROJO |
ROSA |
NARANJA |
AMARILLO |
VERDE |
FUSCIA |
AZULTURQ |
AZUL { return token(yytext(), "COLOR", yyline, yycolumn); }

/*OPERADORES DE AGRUPACION*/
"{" { return token(yytext(), "LLAVE_ABIERTA", yyline, yycolumn); }
"}" { return token(yytext(), "LLAVE_CERRADA", yyline, yycolumn); }


/*OPERADORES */
"=" { return token(yytext(), "OPERADOR_ASIGNACION", yyline, yycolumn); }
"+" { return token(yytext(), "OPERADOR_MAS", yyline, yycolumn); }
"-" { return token(yytext(), "OPERADOR_MENOS", yyline, yycolumn); }
"*" { return token(yytext(), "OPERADOR_MULTIPLICAR", yyline, yycolumn); }
"/" { return token(yytext(), "OPERADOR_DIVIDIR", yyline, yycolumn); }
"&&" { return token(yytext(), "OPERADOR_AND", yyline, yycolumn); }
"||" { return token(yytext(), "OPERADOR_OR", yyline, yycolumn); }
"!" { return token(yytext(), "OPERADOR_DIFERENTEQUE", yyline, yycolumn); }
">" { return token(yytext(), "OPERADOR_MAYORQUE", yyline, yycolumn); }
"<" { return token(yytext(), "OPERADOR_MENORQUE", yyline, yycolumn); }
"++" { return token(yytext(), "OPERADOR_INCREMENTO", yyline, yycolumn); }
"--" { return token(yytext(), "OPERADOR_DECREMENTO", yyline, yycolumn); }
">=" { return token(yytext(), "OPERADOR_MAYORIGUALQUE", yyline, yycolumn); }
"<=" { return token(yytext(), "OPERADOR_MENORIGUALQUE", yyline, yycolumn); }
"==" { return token(yytext(), "OPERADOR_EQUIVALENCIA", yyline, yycolumn); }


/*PUNTUACION */
";" { return token(yytext(), "FIN_DE_SENTENCIA", yyline, yycolumn); }

, { return token(yytext(), "COMA", yyline, yycolumn); }
"(" { return token(yytext(), "ABRE_PARENTESIS", yyline, yycolumn); }
")" { return token(yytext(), "CIERRA_PARENTESIS", yyline, yycolumn); }
/*PALABRAS RESERVADAS*/

if { return token(yytext(), "INICIO_CONDICIONAL", yyline, yycolumn); }
else { return token(yytext(), "SEGUIR_CONDICIONAL", yyline, yycolumn); }
while  { return token(yytext(), "CICLO_WHILE", yyline, yycolumn); }
for  { return token(yytext(), "CICLO_FOR", yyline, yycolumn); }
do  { return token(yytext(), "CICLO_DOWHILE", yyline, yycolumn); }
this |
return 
{ return token(yytext(), "PALABRA_RESERVADA", yyline, yycolumn); }

verdadero | true { return token(yytext(), "VERDADERO", yyline, yycolumn); }
falso  | false { return token(yytext(), "FALSO", yyline, yycolumn); }

/* FUNCION */
MOVER_ARRIBA{return token(yytext(), "FUNCION_M_ARRIBA", yyline, yycolumn); }
MOVER_ABAJO {return token(yytext(), "FUNCION_M_ABAJO", yyline, yycolumn); }
MOVER_IZQ {return token(yytext(), "FUNCION_M_IZQ", yyline, yycolumn); }
MOVER_DER{return token(yytext(), "FUNCION_M_DER", yyline, yycolumn); }
ROTAR {return token(yytext(), "FUNCION_ROTAR", yyline, yycolumn); }
POSX{return token(yytext(), "FUNCION_POSX", yyline, yycolumn); }
POSY {return token(yytext(), "FUNCION_POSY", yyline, yycolumn); }
SALTAR {return token(yytext(), "FUNCION_SALTAR", yyline, yycolumn); }
SONIDO {return token(yytext(), "FUNCION_SONIDO", yyline, yycolumn); }
CREAROBJETO {return token(yytext(), "FUNCION_CREAROBJETO", yyline, yycolumn); }

/*ERRORES*/

/*identificador no valido*/
@{Numero}{Letra}* { return token(yytext(), "ERROR_1", yyline, yycolumn); }
/*numero no valido*/
0{Numero}* { return token(yytext(), "ERROR_2", yyline, yycolumn); }

. { return token(yytext(), "ERROR_3", yyline, yycolumn); }