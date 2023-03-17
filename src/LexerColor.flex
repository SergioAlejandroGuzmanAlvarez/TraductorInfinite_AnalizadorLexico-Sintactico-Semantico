import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }
%}
/* Variables básicas de comentarios y espacios */



TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
A=[!¡]
Identificador = {Letra}({Letra}|{Digito})*
P=[.]
/* Número */
Numero = 0 | [1-9][0-9]*
N=[0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(255, 255, 255)); }
{EspacioEnBlanco} { /*Ignorar*/ }



/* ------------------------------------------------------------ */
/* IDENTIFICADOR*/
@{Identificador} { return textColor(yychar, yylength(), new Color(53, 255, 249)); }
/* TIPOS DE DATO */
str |
int |
dec | 
bool { return textColor(yychar, yylength(), new Color(255, 198, 6)); }

/* NUMERO*/
 0 | [1-9][0-9]* { return textColor(yychar, yylength(), new Color(255, 255, 0)); }
{Numero}.[0]*{Numero}  { return textColor(yychar, yylength(), new Color(255, 255, 0)); }
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
AZUL { return textColor(yychar, yylength(), new Color(116, 254, 1)); }

/*OPERADORES DE AGRUPACION*/
"<(" |
"(" |
")" |
","|
")>" { return textColor(yychar, yylength(), new Color(214,88, 245)); }


/*OPERADORES */
= |
+ |
- |
* |
/ |
&& |
|| |
! |
> |
< |
>= |
<= |
++ |
-- { return textColor(yychar, yylength(), new Color(116, 254, 1)); }

/*PUNTUACION */
";" { return textColor(yychar, yylength(), new Color(190, 66, 0)); }

/*CADENA*/
'({Letra}|{Digito}|{EspacioEnBlanco})*' {return textColor(yychar, yylength(), new Color(255, 255, 255)); }

/*PALABRAS RESERVADAS*/

if |
else |
while  |
for  |
do  |
this |
return 
 
 { return textColor(yychar, yylength(), new Color(255, 198, 6)); }
verdadero | true  { return textColor(yychar, yylength(), new Color(255, 198, 6)); }
falso | false { return textColor(yychar, yylength(), new Color(255, 198, 6)); }
/* FUNCION */
F_{Letra}({Letra}|{Digito})*  { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
MOVER_ARRIBA{ return textColor(yychar, yylength(), new Color(188, 254, 94)); }
MOVER_ABAJO { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
MOVER_IZQ { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
MOVER_DER{ return textColor(yychar, yylength(), new Color(188, 254, 94)); }
ROTAR { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
POSX { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
POSY { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
SALTAR { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
SONIDO { return textColor(yychar, yylength(), new Color(188, 254, 94)); }
CREAROBJETO { return textColor(yychar, yylength(), new Color(188, 254, 94)); }

/*ERRORES*/ 

/*identificador no valido*/
@{Numero}{Letra}* { return textColor(yychar, yylength(), new Color(255, 5, 5)); }
/*numero no valido*/
0{Numero}* { return textColor(yychar, yylength(), new Color(255, 5, 5)); }

. { return textColor(yychar, yylength(), new Color(255, 0, 0)); }