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

%{}
  /**
    * '#+' stride demarking start/end of raw string/byte literal
    */
  private int zzShaStride = -1;

  /**
    * Dedicated storage for starting position of some previously successful
    * match
    */
  private int zzPostponedMarkedPos = -1;

  /**
    * Dedicated nested-comment level counter
    */
  private int zzNestedCommentLevel = 0;
%}

%{
  IElementType imbueBlockComment() {
      assert(zzNestedCommentLevel == 0);
      yybegin(YYINITIAL);

      zzStartRead = zzPostponedMarkedPos;
      zzPostponedMarkedPos = -1;

      if (yylength() >= 3) {
          if (yycharat(2) == '!') {
              return INNER_BLOCK_DOC_COMMENT;
          } else if (yycharat(2) == '*' && (yylength() == 3 || yycharat(3) != '*' && yycharat(3) != '/')) {
              return OUTER_BLOCK_DOC_COMMENT;
          }
      }

      return BLOCK_COMMENT;
  }

  IElementType imbueOuterEolComment(){
    yybegin(YYINITIAL);

    zzStartRead = zzPostponedMarkedPos;
    zzPostponedMarkedPos = -1;

    return OUTER_EOL_DOC_COMMENT;
  }
%}

%public
%class VhlLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%s IN_BLOCK_COMMENT
%s IN_OUTER_EOL_COMMENT

EOL_WS           = \n | \r | \r\n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {EOL_WS} | {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

DISCRETE_UNSIGNED_TY_IMPLICIT=u[1-9][0-9]*
DISCRETE_SIGNED_TY_IMPLICIT=i[1-9][0-9]*
FIXED_UNSIGNED_TY_IMPLICIT=uq[1-9][0-9]*
FIXED_SIGNED_TY_IMPLICIT=iq[1-9][0-9]*
FLOAT_TY_IMPLICIT=f[1-9][0-9]*

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

INNER_EOL_DOC = ({LINE_WS}*"//!".*{EOL_WS})*({LINE_WS}*"//!".*)
// !(!a|b) is a (set) difference between a and b.
EOL_DOC_LINE  = {LINE_WS}*!(!("///".*)|("////".*))

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
  "`"                                  { return BACKTICK; }
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
//  "fixed_ty"                           { return FIXED_TY; }
//  "floating_ty"                        { return FLOATING_TY; }
//  "textual_ty"                         { return TEXTUAL_TY; }
  "char"                               { return CHAR; }
  "str"                                { return STR; }
  "bool"                               { return BOOL; }
//  "char_lit"                           { return CHAR_LIT; }
//  "tuple_lit"                          { return TUPLE_LIT; }
//  "struct_lit"                         { return STRUCT_LIT; }
//  "enum_lit"                           { return ENUM_LIT; }
//  "unary_expr"                         { return UNARY_EXPR; }
//  "tuple_of_expressions"               { return TUPLE_OF_EXPRESSIONS; }
//  "expression_parenthesized"           { return EXPRESSION_PARENTHESIZED; }

  "/*"                            { yybegin(IN_BLOCK_COMMENT); yypushback(2); }

  "////" .*                       { return EOL_COMMENT; }
  {INNER_EOL_DOC}                 { return INNER_EOL_DOC_COMMENT; }
  {EOL_DOC_LINE}                  { yybegin(IN_OUTER_EOL_COMMENT);
                                    zzPostponedMarkedPos = zzStartRead; }
  "//" .*                         { return EOL_COMMENT; }

  {DISCRETE_UNSIGNED_TY_IMPLICIT}      { return DISCRETE_UNSIGNED_TY_IMPLICIT; }
  {DISCRETE_SIGNED_TY_IMPLICIT}        { return DISCRETE_SIGNED_TY_IMPLICIT; }
  {FIXED_UNSIGNED_TY_IMPLICIT}         { return FIXED_UNSIGNED_TY_IMPLICIT; }
  {FIXED_SIGNED_TY_IMPLICIT}           { return FIXED_SIGNED_TY_IMPLICIT; }
  {FLOAT_TY_IMPLICIT}                  { return FLOAT_TY_IMPLICIT; }
  {STRING_LITERAL}                     { return STRING_LITERAL; }
  {CHAR_LITERAL}                       { return CHAR_LITERAL; }
  {FLOAT_LIT_RAW}                      { return FLOAT_LIT_RAW; }
  {DEC_LIT_RAW}                        { return DEC_LIT_RAW; }
  {HEX_LIT_RAW}                        { return HEX_LIT_RAW; }
  {OCT_LIT_RAW}                        { return OCT_LIT_RAW; }
  {BIN_LIT_RAW}                        { return BIN_LIT_RAW; }

  {IDENT}                              { return IDENT; }
  {IDENT_CONTINUE}                     { return IDENT_CONTINUE; }

  {WHITE_SPACE}                   { return WHITE_SPACE; }
}

///////////////////////////////////////////////////////////////////////////////////////////////////
// Comments
///////////////////////////////////////////////////////////////////////////////////////////////////

<IN_BLOCK_COMMENT> {
  "/*"    { if (zzNestedCommentLevel++ == 0)
              zzPostponedMarkedPos = zzStartRead;
          }

  "*/"    { if (--zzNestedCommentLevel == 0)
              return imbueBlockComment();
          }

  <<EOF>> { zzNestedCommentLevel = 0; return imbueBlockComment(); }

  [^]     { }
}

<IN_OUTER_EOL_COMMENT>{
  {EOL_WS}{LINE_WS}*"////"   { yybegin(YYINITIAL);
                               yypushback(yylength());
                               return imbueOuterEolComment();}
  {EOL_WS}{EOL_DOC_LINE}     {}
  <<EOF>>                    { return imbueOuterEolComment(); }
  [^]                        { yybegin(YYINITIAL);
                               yypushback(1);
                               return imbueOuterEolComment();}
}

[^] { return BAD_CHARACTER; }
