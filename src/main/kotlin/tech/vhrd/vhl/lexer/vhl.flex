package tech.vhrd.vhl;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static tech.vhrd.vhl.psi.VhlTypes.*;

%%

%{
  public VhlLexer() {
    this((java.io.Reader)null);
  }

  private boolean is_in_uri = false;
%}

%public
%class VhlLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

//EOL=\R
EOL_WS           = \n | \r | \r\n
NL = \n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {EOL_WS} | {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

IDENT = ("r#")?[_\p{xidstart}][\p{xidcontinue}]*
SUFFIX     = {IDENT}

EXPONENT      = [eE] [-+]? [0-9_]+
INT_LITERAL = ( {DEC_LITERAL}
              | {HEX_LITERAL}
              | {OCT_LITERAL}
              | {BIN_LITERAL} ) {EXPONENT}? {SUFFIX}?

DEC_LITERAL = [0-9] [0-9_]*
HEX_LITERAL = "0x" [a-fA-F0-9_]*
OCT_LITERAL = "0o" [0-7_]*
BIN_LITERAL = "0b" [01_]*

CHAR_LITERAL   = ( \' ( [^\\\'\r\n] | \\[^\r\n] | "\\x" [a-fA-F0-9]+ | "\\u{" [a-fA-F0-9][a-fA-F0-9_]* "}"? )? ( \' {SUFFIX}? | \\ )? )
               | ( \' [\p{xidcontinue}]* \' {SUFFIX}? )
STRING_LITERAL = \" ( [^\\\"] | \\[^] )* ( \" {SUFFIX}? | \\ )?

DISCRETE_UNSIGNED_TY_IMPLICIT = u[1-9][0-9]*

%%
<YYINITIAL> {

  "{"                 { return LBRACE; }
  "}"                 { return RBRACE; }
  "["                 { return LBRACK; }
  "]"                 { return RBRACK; }
  "("                 { return LPAREN; }
  ")"                 { return RPAREN; }
  ":"                 { return COLON; }
  "::"                { return COLONCOLON; }
  ";"                 { return SEMICOLON; }
  ","                 { return COMMA; }
  "="                 { return EQ; }
  "!="                { return EXCLEQ; }
  "=="                { return EQEQ; }
  "#"                 { return SHA; }
  "#."                { return SHADOT; }
  "#.."               { return SHADOTDOT; }
  "!"                 { return EXCL; }
  "+"                 { return PLUS; }
  "-"                 { return MINUS; }
  "&&"                { return ANDAND; }
  "&"                 { return AND; }
  "|"                 { return OR; }
  "<"                 { return LT; }
  "^"                 { return XOR; }
  "*"                 { return MUL; }
  "/"                 { return DIV; }
  "%"                 { return REM; }
  ">"                 { return GT; }
  "."                 { return DOT; }
  ".."                { return DOTDOT; }
  "..."               { return DOTDOTDOT; }
  "..="               { return DOTDOTEQ; }
  "_"                 { return UNDERSCORE; }
  "||"                { return OROR; }
  "type"              { return TYPE_KW; }
  "struct"            { return STRUCT; }
  "UnitStructTail"    { return UNITSTRUCTTAIL; }

  "u{"  { return DISCRETE_UNSIGNED_TY_EXPR; }
  {DISCRETE_UNSIGNED_TY_IMPLICIT} { return DISCRETE_UNSIGNED_TY_IMPLICIT; }
  {IDENT}             { return IDENT; }
  {INT_LITERAL}       { return INTEGER_LITERAL; }
  {STRING_LITERAL}                { return STRING_LITERAL; }

  {WHITE_SPACE}       { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }
