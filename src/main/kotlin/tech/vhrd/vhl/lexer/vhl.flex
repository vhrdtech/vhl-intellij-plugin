package tech.vhrd.vhl.lexer;

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

EOL_WS           = \n | \r | \r\n
NL = \n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {EOL_WS} | {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

COMMENT=(!"///")"//".*
DOC_LINE="///".*
DISCRETE_UNSIGNED_TY_IMPLICIT=u[1-9][0-9]*
DISCRETE_SIGNED_TY_IMPLICIT=i[1-9][0-9]*

SUFFIX     = {IDENT}
CHAR_LITERAL   = ( \' ( [^\\\'\r\n] | \\[^\r\n] | "\\x" [a-fA-F0-9]+ | "\\u{" [a-fA-F0-9][a-fA-F0-9_]* "}"? )? ( \' {SUFFIX}? | \\ )? )
               | ( \' [\p{xidcontinue}]* \' {SUFFIX}? )
STRING_LITERAL = \" ( [^\\\"] | \\[^] )* ( \" {SUFFIX}? | \\ )?

FLOAT_LIT_RAW=[0-9][0-9_]*.[0-9][0-9_]*
DEC_LIT_RAW=[0-9][0-9_]*
HEX_LIT_RAW=0x[0-9a-f_]+
OCT_LIT_RAW=0o[0-7_]+
BIN_LIT_RAW=0b[01_]+

IDENT = [_\p{xidstart}][\p{xidcontinue}]*
IDENT_CONTINUE=[\p{xidcontinue}]+

%%
<YYINITIAL> {
  "{"                                  { return LBRACE; }
  "}"                                  { return RBRACE; }
  "["                                  { return LBRACK; }
  "]"                                  { return RBRACK; }
  "("                                  { return LPAREN; }
  ")"                                  { return RPAREN; }
  ":"                                  { return COLON; }
  "::"                                 { return COLONCOLON; }
  ";"                                  { return SEMICOLON; }
  ","                                  { return COMMA; }
  "="                                  { return EQ; }
  "!="                                 { return EXCLEQ; }
  "=="                                 { return EQEQ; }
  "!"                                  { return EXCL; }
  "+"                                  { return PLUS; }
  "-"                                  { return MINUS; }
  "&&"                                 { return ANDAND; }
  "&"                                  { return AND; }
  "|"                                  { return OR; }
  "<"                                  { return LT; }
  "^"                                  { return XOR; }
  "*"                                  { return MUL; }
  "/"                                  { return DIV; }
  "%"                                  { return REM; }
  ">"                                  { return GT; }
  "."                                  { return DOT; }
  ".."                                 { return DOTDOT; }
  "..."                                { return DOTDOTDOT; }
  "..="                                { return DOTDOTEQ; }
  "?"                                  { return UNBOUND; }
  "@"                                  { return BOUND; }
  "min"                                { return MIN_BOUND; }
  "max"                                { return MAX_BOUND; }
  "_"                                  { return UNDERSCORE; }
  "#"                                  { return HASH; }
  "||"                                 { return OROR; }
  "type"                               { return TYPE_KW; }
  "rs"                                 { return RS_KW; }
  "struct"                             { return STRUCT_KW; }
  "enum"                               { return ENUM_KW; }
  "fn"                                 { return FN_KW; }
  "const"                              { return CONST_KW; }
  "true"                               { return TRUE; }
  "false"                              { return FALSE; }
  "rw"                                 { return RW_KW; }
  "ro"                                 { return RO_KW; }
  "wo"                                 { return WO_KW; }
  "impl"                               { return IMPL_KW; }
  "stream"                             { return STREAM_KW; }
  "observe"                            { return OBSERVE_KW; }
  "fixed_ty"                           { return FIXED_TY; }
  "floating_ty"                        { return FLOATING_TY; }
  "textual_ty"                         { return TEXTUAL_TY; }
  "char_lit"                           { return CHAR_LIT; }
  "tuple_lit"                          { return TUPLE_LIT; }
  "struct_lit"                         { return STRUCT_LIT; }
  "enum_lit"                           { return ENUM_LIT; }
  "unary_expr"                         { return UNARY_EXPR; }
  "tuple_of_expressions"               { return TUPLE_OF_EXPRESSIONS; }
  "expression_parenthesized"           { return EXPRESSION_PARENTHESIZED; }

  {COMMENT}                            { return COMMENT; }
  {DOC_LINE}                           { return DOC_LINE; }
  {DISCRETE_UNSIGNED_TY_IMPLICIT}      { return DISCRETE_UNSIGNED_TY_IMPLICIT; }
  {DISCRETE_SIGNED_TY_IMPLICIT}        { return DISCRETE_SIGNED_TY_IMPLICIT; }
  {STRING_LITERAL}                     { return STRING_LITERAL; }
  {FLOAT_LIT_RAW}                      { return FLOAT_LIT_RAW; }
  {DEC_LIT_RAW}                        { return DEC_LIT_RAW; }
  {HEX_LIT_RAW}                        { return HEX_LIT_RAW; }
  {OCT_LIT_RAW}                        { return OCT_LIT_RAW; }
  {BIN_LIT_RAW}                        { return BIN_LIT_RAW; }
  {IDENT}                              { return IDENT; }
  {IDENT_CONTINUE}                     { return IDENT_CONTINUE; }

  {WHITE_SPACE}                   { return WHITE_SPACE; }
}

[^] { return BAD_CHARACTER; }
