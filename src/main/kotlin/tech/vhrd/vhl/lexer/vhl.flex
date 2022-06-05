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
%}

%public
%class VhlLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
IDENT=[0-9_a-zA-Z]+

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }

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

  {SPACE}             { return SPACE; }
  {IDENT}             { return IDENT; }

}

[^] { return BAD_CHARACTER; }
