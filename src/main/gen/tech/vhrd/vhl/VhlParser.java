// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static tech.vhrd.vhl.psi.VhlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class VhlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '%' | '&' | '|' | '^' | '<<' | '>>' | '..=' | '..' | '.'
  public static boolean BinOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BinOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIN_OP, "<bin op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, REM);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, XOR);
    if (!r) r = consumeToken(b, "<<");
    if (!r) r = consumeToken(b, ">>");
    if (!r) r = consumeToken(b, DOTDOTEQ);
    if (!r) r = consumeToken(b, DOTDOT);
    if (!r) r = consumeToken(b, DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' lit (',' lit)* ','? ']'
  public static boolean array_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_lit")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && lit(b, l + 1);
    r = r && array_lit_2(b, l + 1);
    r = r && array_lit_3(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, ARRAY_LIT, r);
    return r;
  }

  // (',' lit)*
  private static boolean array_lit_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_lit_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_lit_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_lit_2", c)) break;
    }
    return true;
  }

  // ',' lit
  private static boolean array_lit_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_lit_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && lit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean array_lit_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_lit_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // '[' ty ';' num_bound ']'
  public static boolean array_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_ty")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && ty(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && num_bound(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, ARRAY_TY, r);
    return r;
  }

  /* ********************************************************** */
  // path attribute_input?
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && attribute_1(b, l + 1);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  // attribute_input?
  private static boolean attribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1")) return false;
    attribute_input(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ( '(' expr ')' ) | ('~' 'tt')
  public static boolean attribute_input(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_input")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_INPUT, "<attribute input>");
    r = attribute_input_0(b, l + 1);
    if (!r) r = attribute_input_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' expr ')'
  private static boolean attribute_input_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_input_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // '~' 'tt'
  private static boolean attribute_input_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_input_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "~");
    r = r && consumeToken(b, "tt");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' named_field_decl_with_recover* '}'
  public static boolean block_fields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_fields")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_FIELDS, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, block_fields_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // named_field_decl_with_recover*
  private static boolean block_fields_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_fields_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!named_field_decl_with_recover(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_fields_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'true' | 'false'
  public static boolean bool_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_lit")) return false;
    if (!nextTokenIs(b, "<bool lit>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_LIT, "<bool lit>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'bool'
  public static boolean bool_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_ty")) return false;
    if (!nextTokenIs(b, BOOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOL);
    exit_section_(b, m, BOOL_TY, r);
    return r;
  }

  /* ********************************************************** */
  // path index_arguments call_arguments
  static boolean call_after_index(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_after_index")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && index_arguments(b, l + 1);
    r = r && call_arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' expr_list? ')'
  public static boolean call_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && call_arguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, CALL_ARGUMENTS, r);
    return r;
  }

  // expr_list?
  private static boolean call_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_arguments_1")) return false;
    expr_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // call_then_index | call_after_index | call_only
  public static boolean call_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_then_index(b, l + 1);
    if (!r) r = call_after_index(b, l + 1);
    if (!r) r = call_only(b, l + 1);
    exit_section_(b, m, CALL_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // path call_arguments
  static boolean call_only(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_only")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && call_arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // path call_arguments index_arguments
  static boolean call_then_index(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_then_index")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && call_arguments(b, l + 1);
    r = r && index_arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CHAR_LITERAL
  public static boolean char_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "char_lit")) return false;
    if (!nextTokenIs(b, CHAR_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHAR_LITERAL);
    exit_section_(b, m, CHAR_LIT, r);
    return r;
  }

  /* ********************************************************** */
  // '_'
  public static boolean derive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "derive")) return false;
    if (!nextTokenIs(b, UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNDERSCORE);
    exit_section_(b, m, DERIVE, r);
    return r;
  }

  /* ********************************************************** */
  // (HEX_LIT_RAW | BIN_LIT_RAW | OCT_LIT_RAW | DEC_LIT_RAW) discrete_ty?
  public static boolean discrete_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_lit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DISCRETE_LIT, "<discrete lit>");
    r = discrete_lit_0(b, l + 1);
    r = r && discrete_lit_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // HEX_LIT_RAW | BIN_LIT_RAW | OCT_LIT_RAW | DEC_LIT_RAW
  private static boolean discrete_lit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_lit_0")) return false;
    boolean r;
    r = consumeToken(b, HEX_LIT_RAW);
    if (!r) r = consumeToken(b, BIN_LIT_RAW);
    if (!r) r = consumeToken(b, OCT_LIT_RAW);
    if (!r) r = consumeToken(b, DEC_LIT_RAW);
    return r;
  }

  // discrete_ty?
  private static boolean discrete_lit_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_lit_1")) return false;
    discrete_ty(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DISCRETE_SIGNED_TY_IMPLICIT
  public static boolean discrete_signed_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_signed_ty")) return false;
    if (!nextTokenIs(b, DISCRETE_SIGNED_TY_IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DISCRETE_SIGNED_TY_IMPLICIT);
    exit_section_(b, m, DISCRETE_SIGNED_TY, r);
    return r;
  }

  /* ********************************************************** */
  // (discrete_signed_ty | discrete_unsigned_ty) '_'? num_bound_braced? '_'? unit_expr_ticked?
  public static boolean discrete_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_ty")) return false;
    if (!nextTokenIs(b, "<discrete ty>", DISCRETE_SIGNED_TY_IMPLICIT, DISCRETE_UNSIGNED_TY_IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DISCRETE_TY, "<discrete ty>");
    r = discrete_ty_0(b, l + 1);
    r = r && discrete_ty_1(b, l + 1);
    r = r && discrete_ty_2(b, l + 1);
    r = r && discrete_ty_3(b, l + 1);
    r = r && discrete_ty_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // discrete_signed_ty | discrete_unsigned_ty
  private static boolean discrete_ty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_ty_0")) return false;
    boolean r;
    r = discrete_signed_ty(b, l + 1);
    if (!r) r = discrete_unsigned_ty(b, l + 1);
    return r;
  }

  // '_'?
  private static boolean discrete_ty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_ty_1")) return false;
    consumeToken(b, UNDERSCORE);
    return true;
  }

  // num_bound_braced?
  private static boolean discrete_ty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_ty_2")) return false;
    num_bound_braced(b, l + 1);
    return true;
  }

  // '_'?
  private static boolean discrete_ty_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_ty_3")) return false;
    consumeToken(b, UNDERSCORE);
    return true;
  }

  // unit_expr_ticked?
  private static boolean discrete_ty_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_ty_4")) return false;
    unit_expr_ticked(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DISCRETE_UNSIGNED_TY_IMPLICIT
  public static boolean discrete_unsigned_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_unsigned_ty")) return false;
    if (!nextTokenIs(b, DISCRETE_UNSIGNED_TY_IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DISCRETE_UNSIGNED_TY_IMPLICIT);
    exit_section_(b, m, DISCRETE_UNSIGNED_TY, r);
    return r;
  }

  /* ********************************************************** */
  // (OUTER_BLOCK_DOC_COMMENT | OUTER_EOL_DOC_COMMENT)* outer_attr*
  static boolean doc_attr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_attr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = doc_attr_0(b, l + 1);
    r = r && doc_attr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (OUTER_BLOCK_DOC_COMMENT | OUTER_EOL_DOC_COMMENT)*
  private static boolean doc_attr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_attr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!doc_attr_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "doc_attr_0", c)) break;
    }
    return true;
  }

  // OUTER_BLOCK_DOC_COMMENT | OUTER_EOL_DOC_COMMENT
  private static boolean doc_attr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_attr_0_0")) return false;
    boolean r;
    r = consumeToken(b, OUTER_BLOCK_DOC_COMMENT);
    if (!r) r = consumeToken(b, OUTER_EOL_DOC_COMMENT);
    return r;
  }

  // outer_attr*
  private static boolean doc_attr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doc_attr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!outer_attr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "doc_attr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // doc_attr 'enum' ident enum_items
  public static boolean enum_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_def")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEF, "<enum def>");
    r = doc_attr(b, l + 1);
    r = r && consumeTokens(b, 0, ENUM_KW, IDENT);
    r = r && enum_items(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ident enum_item_kind?
  public static boolean enum_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_item")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && enum_item_1(b, l + 1);
    exit_section_(b, m, ENUM_ITEM, r);
    return r;
  }

  // enum_item_kind?
  private static boolean enum_item_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_item_1")) return false;
    enum_item_kind(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '=' expr
  public static boolean enum_item_discriminant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_item_discriminant")) return false;
    if (!nextTokenIs(b, EQ)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && expr(b, l + 1);
    exit_section_(b, m, ENUM_ITEM_DISCRIMINANT, r);
    return r;
  }

  /* ********************************************************** */
  // block_fields | tuple_ty | enum_item_discriminant
  static boolean enum_item_kind(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_item_kind")) return false;
    boolean r;
    r = block_fields(b, l + 1);
    if (!r) r = tuple_ty(b, l + 1);
    if (!r) r = enum_item_discriminant(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '{' enum_item (',' enum_item)* ','? '}'
  static boolean enum_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_items")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && enum_item(b, l + 1);
    r = r && enum_items_2(b, l + 1);
    r = r && enum_items_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' enum_item)*
  private static boolean enum_items_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_items_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enum_items_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enum_items_2", c)) break;
    }
    return true;
  }

  // ',' enum_item
  private static boolean enum_items_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_items_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enum_item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean enum_items_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_items_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // infix_expr | expr_inner
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = infix_expr(b, l + 1);
    if (!r) r = expr_inner(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // call_expr
  //                     | index_into_expr
  //                     | lit
  //                     | (&(standard_ty | (path generics)) ty)
  //                     | path
  //                     | unary_expr
  //                     | tuple_of_expressions
  //                     | expression_parenthesized
  static boolean expr_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_inner")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = call_expr(b, l + 1);
    if (!r) r = index_into_expr(b, l + 1);
    if (!r) r = lit(b, l + 1);
    if (!r) r = expr_inner_3(b, l + 1);
    if (!r) r = path(b, l + 1);
    if (!r) r = consumeToken(b, UNARY_EXPR);
    if (!r) r = consumeToken(b, TUPLE_OF_EXPRESSIONS);
    if (!r) r = consumeToken(b, EXPRESSION_PARENTHESIZED);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(standard_ty | (path generics)) ty
  private static boolean expr_inner_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_inner_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_inner_3_0(b, l + 1);
    r = r && ty(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &(standard_ty | (path generics))
  private static boolean expr_inner_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_inner_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = expr_inner_3_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // standard_ty | (path generics)
  private static boolean expr_inner_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_inner_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = standard_ty(b, l + 1);
    if (!r) r = expr_inner_3_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // path generics
  private static boolean expr_inner_3_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_inner_3_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && generics(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (',' expr)* ','?
  public static boolean expr_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_LIST, "<expr list>");
    r = expr(b, l + 1);
    r = r && expr_list_1(b, l + 1);
    r = r && expr_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' expr)*
  private static boolean expr_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_list_1", c)) break;
    }
    return true;
  }

  // ',' expr
  private static boolean expr_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean expr_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_list_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // '`' expr '`'
  public static boolean expr_ticked(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_ticked")) return false;
    if (!nextTokenIs(b, BACKTICK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BACKTICK);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, BACKTICK);
    exit_section_(b, m, EXPR_TICKED, r);
    return r;
  }

  /* ********************************************************** */
  // (INNER_BLOCK_DOC_COMMENT | INNER_EOL_DOC_COMMENT)* item*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && file_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INNER_BLOCK_DOC_COMMENT | INNER_EOL_DOC_COMMENT)*
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!file_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0", c)) break;
    }
    return true;
  }

  // INNER_BLOCK_DOC_COMMENT | INNER_EOL_DOC_COMMENT
  private static boolean file_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0_0")) return false;
    boolean r;
    r = consumeToken(b, INNER_BLOCK_DOC_COMMENT);
    if (!r) r = consumeToken(b, INNER_EOL_DOC_COMMENT);
    return r;
  }

  // item*
  private static boolean file_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // FIXED_SIGNED_TY_IMPLICIT
  public static boolean fixed_signed_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_signed_ty")) return false;
    if (!nextTokenIs(b, FIXED_SIGNED_TY_IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FIXED_SIGNED_TY_IMPLICIT);
    exit_section_(b, m, FIXED_SIGNED_TY, r);
    return r;
  }

  /* ********************************************************** */
  // (fixed_signed_ty | fixed_unsigned_ty) '_'? num_bound_braced? '_'? unit_expr_ticked?
  public static boolean fixed_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_ty")) return false;
    if (!nextTokenIs(b, "<fixed ty>", FIXED_SIGNED_TY_IMPLICIT, FIXED_UNSIGNED_TY_IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIXED_TY, "<fixed ty>");
    r = fixed_ty_0(b, l + 1);
    r = r && fixed_ty_1(b, l + 1);
    r = r && fixed_ty_2(b, l + 1);
    r = r && fixed_ty_3(b, l + 1);
    r = r && fixed_ty_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // fixed_signed_ty | fixed_unsigned_ty
  private static boolean fixed_ty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_ty_0")) return false;
    boolean r;
    r = fixed_signed_ty(b, l + 1);
    if (!r) r = fixed_unsigned_ty(b, l + 1);
    return r;
  }

  // '_'?
  private static boolean fixed_ty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_ty_1")) return false;
    consumeToken(b, UNDERSCORE);
    return true;
  }

  // num_bound_braced?
  private static boolean fixed_ty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_ty_2")) return false;
    num_bound_braced(b, l + 1);
    return true;
  }

  // '_'?
  private static boolean fixed_ty_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_ty_3")) return false;
    consumeToken(b, UNDERSCORE);
    return true;
  }

  // unit_expr_ticked?
  private static boolean fixed_ty_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_ty_4")) return false;
    unit_expr_ticked(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FIXED_UNSIGNED_TY_IMPLICIT
  public static boolean fixed_unsigned_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fixed_unsigned_ty")) return false;
    if (!nextTokenIs(b, FIXED_UNSIGNED_TY_IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FIXED_UNSIGNED_TY_IMPLICIT);
    exit_section_(b, m, FIXED_UNSIGNED_TY, r);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_LIT_RAW
  public static boolean float_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_lit")) return false;
    if (!nextTokenIs(b, FLOAT_LIT_RAW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOAT_LIT_RAW);
    exit_section_(b, m, FLOAT_LIT, r);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_TY_IMPLICIT '_'? num_bound_braced? '_'? unit_expr_ticked?
  public static boolean floating_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floating_ty")) return false;
    if (!nextTokenIs(b, FLOAT_TY_IMPLICIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOAT_TY_IMPLICIT);
    r = r && floating_ty_1(b, l + 1);
    r = r && floating_ty_2(b, l + 1);
    r = r && floating_ty_3(b, l + 1);
    r = r && floating_ty_4(b, l + 1);
    exit_section_(b, m, FLOATING_TY, r);
    return r;
  }

  // '_'?
  private static boolean floating_ty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floating_ty_1")) return false;
    consumeToken(b, UNDERSCORE);
    return true;
  }

  // num_bound_braced?
  private static boolean floating_ty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floating_ty_2")) return false;
    num_bound_braced(b, l + 1);
    return true;
  }

  // '_'?
  private static boolean floating_ty_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floating_ty_3")) return false;
    consumeToken(b, UNDERSCORE);
    return true;
  }

  // unit_expr_ticked?
  private static boolean floating_ty_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floating_ty_4")) return false;
    unit_expr_ticked(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ident type_ascription
  public static boolean fn_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_arg")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && type_ascription(b, l + 1);
    exit_section_(b, m, FN_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // '(' fn_arg? (',' fn_arg)* ','? ')'
  public static boolean fn_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_args")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && fn_args_1(b, l + 1);
    r = r && fn_args_2(b, l + 1);
    r = r && fn_args_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FN_ARGS, r);
    return r;
  }

  // fn_arg?
  private static boolean fn_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_args_1")) return false;
    fn_arg(b, l + 1);
    return true;
  }

  // (',' fn_arg)*
  private static boolean fn_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_args_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fn_args_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fn_args_2", c)) break;
    }
    return true;
  }

  // ',' fn_arg
  private static boolean fn_args_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_args_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && fn_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean fn_args_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_args_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // '->' ty
  public static boolean fn_ret_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_ret_ty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FN_RET_TY, "<fn ret ty>");
    r = consumeToken(b, "->");
    r = r && ty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'fn' fn_args fn_ret_ty?
  public static boolean fn_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_ty")) return false;
    if (!nextTokenIs(b, FN_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN_KW);
    r = r && fn_args(b, l + 1);
    r = r && fn_ty_2(b, l + 1);
    exit_section_(b, m, FN_TY, r);
    return r;
  }

  // fn_ret_ty?
  private static boolean fn_ty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fn_ty_2")) return false;
    fn_ret_ty(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // expr | ty
  public static boolean generic_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_PARAM, "<generic param>");
    r = expr(b, l + 1);
    if (!r) r = ty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '<' generic_param (',' generic_param)* ','? '>'
  public static boolean generics(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generics")) return false;
    if (!nextTokenIs(b, LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && generic_param(b, l + 1);
    r = r && generics_2(b, l + 1);
    r = r && generics_3(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, GENERICS, r);
    return r;
  }

  // (',' generic_param)*
  private static boolean generics_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generics_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!generics_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "generics_2", c)) break;
    }
    return true;
  }

  // ',' generic_param
  private static boolean generics_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generics_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && generic_param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean generics_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generics_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // '[' expr_list? ']'
  public static boolean index_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_arguments")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && index_arguments_1(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, INDEX_ARGUMENTS, r);
    return r;
  }

  // expr_list?
  private static boolean index_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_arguments_1")) return false;
    expr_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // path index_arguments
  public static boolean index_into_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_into_expr")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && index_arguments(b, l + 1);
    exit_section_(b, m, INDEX_INTO_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // expr_inner (BinOp expr_inner)+
  static boolean infix_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_inner(b, l + 1);
    r = r && infix_expr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BinOp expr_inner)+
  private static boolean infix_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = infix_expr_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!infix_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "infix_expr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // BinOp expr_inner
  private static boolean infix_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "infix_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BinOp(b, l + 1);
    r = r && expr_inner(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '#!' '[' attribute ']'
  public static boolean inner_attr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inner_attr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INNER_ATTR, "<inner attr>");
    r = consumeToken(b, "#!");
    r = r && consumeToken(b, LBRACK);
    r = r && attribute(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // struct_def | enum_def | type_alias_stmt | xpi_block
  public static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM, "<item>");
    r = struct_def(b, l + 1);
    if (!r) r = enum_def(b, l + 1);
    if (!r) r = type_alias_stmt(b, l + 1);
    if (!r) r = xpi_block(b, l + 1);
    exit_section_(b, l, m, r, false, VhlParser::top_level_recover);
    return r;
  }

  /* ********************************************************** */
  // bool_lit | float_lit | discrete_lit | xpi_serial | char_lit | string_lit | tuple_lit | struct_lit | enum_lit | array_lit
  public static boolean lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIT, "<lit>");
    r = bool_lit(b, l + 1);
    if (!r) r = float_lit(b, l + 1);
    if (!r) r = discrete_lit(b, l + 1);
    if (!r) r = xpi_serial(b, l + 1);
    if (!r) r = char_lit(b, l + 1);
    if (!r) r = string_lit(b, l + 1);
    if (!r) r = consumeToken(b, TUPLE_LIT);
    if (!r) r = consumeToken(b, STRUCT_LIT);
    if (!r) r = consumeToken(b, ENUM_LIT);
    if (!r) r = array_lit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // doc_attr ident type_ascription
  public static boolean named_field_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_field_decl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NAMED_FIELD_DECL, "<named field decl>");
    r = doc_attr(b, l + 1);
    r = r && consumeToken(b, IDENT);
    p = r; // pin = 2
    r = r && type_ascription(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !('}' | ident )
  static boolean named_field_decl_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_field_decl_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !named_field_decl_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | ident
  private static boolean named_field_decl_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_field_decl_recover_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, IDENT);
    return r;
  }

  /* ********************************************************** */
  // !'}' named_field_decl (',' | &'}')
  static boolean named_field_decl_with_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_field_decl_with_recover")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = named_field_decl_with_recover_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, named_field_decl(b, l + 1));
    r = p && named_field_decl_with_recover_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, VhlParser::named_field_decl_recover);
    return r || p;
  }

  // !'}'
  private static boolean named_field_decl_with_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_field_decl_with_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ',' | &'}'
  private static boolean named_field_decl_with_recover_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_field_decl_with_recover_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = named_field_decl_with_recover_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean named_field_decl_with_recover_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_field_decl_with_recover_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // num_unbound | num_bound_min | num_bound_max | num_bound_list
  public static boolean num_bound(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_bound")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_BOUND, "<num bound>");
    r = num_unbound(b, l + 1);
    if (!r) r = num_bound_min(b, l + 1);
    if (!r) r = num_bound_max(b, l + 1);
    if (!r) r = num_bound_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '@' '{' num_bound '}'
  public static boolean num_bound_braced(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_bound_braced")) return false;
    if (!nextTokenIs(b, BOUND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BOUND, LBRACE);
    r = r && num_bound(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, NUM_BOUND_BRACED, r);
    return r;
  }

  /* ********************************************************** */
  // expr_list
  public static boolean num_bound_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_bound_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_BOUND_LIST, "<num bound list>");
    r = expr_list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'max' number_lit
  public static boolean num_bound_max(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_bound_max")) return false;
    if (!nextTokenIs(b, MAX_BOUND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MAX_BOUND);
    r = r && number_lit(b, l + 1);
    exit_section_(b, m, NUM_BOUND_MAX, r);
    return r;
  }

  /* ********************************************************** */
  // 'min' number_lit
  public static boolean num_bound_min(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_bound_min")) return false;
    if (!nextTokenIs(b, MIN_BOUND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MIN_BOUND);
    r = r && number_lit(b, l + 1);
    exit_section_(b, m, NUM_BOUND_MIN, r);
    return r;
  }

  /* ********************************************************** */
  // '?'
  public static boolean num_unbound(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_unbound")) return false;
    if (!nextTokenIs(b, UNBOUND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNBOUND);
    exit_section_(b, m, NUM_UNBOUND, r);
    return r;
  }

  /* ********************************************************** */
  // float_lit | discrete_lit
  public static boolean number_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_lit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LIT, "<number lit>");
    r = float_lit(b, l + 1);
    if (!r) r = discrete_lit(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '#' '[' attribute ']'
  public static boolean outer_attr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outer_attr")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HASH, LBRACK);
    r = r && attribute(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, OUTER_ATTR, r);
    return r;
  }

  /* ********************************************************** */
  // ident ('::' ident)*
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && path_1(b, l + 1);
    exit_section_(b, m, PATH, r);
    return r;
  }

  // ('::' ident)*
  private static boolean path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_1", c)) break;
    }
    return true;
  }

  // '::' ident
  private static boolean path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLONCOLON, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bool_ty
  //     | discrete_ty
  //     | fixed_ty
  //     | floating_ty
  //     | textual_ty
  //     | tuple_ty
  //     | array_ty
  //     | derive
  //     | fn_ty
  static boolean standard_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "standard_ty")) return false;
    boolean r;
    r = bool_ty(b, l + 1);
    if (!r) r = discrete_ty(b, l + 1);
    if (!r) r = fixed_ty(b, l + 1);
    if (!r) r = floating_ty(b, l + 1);
    if (!r) r = textual_ty(b, l + 1);
    if (!r) r = tuple_ty(b, l + 1);
    if (!r) r = array_ty(b, l + 1);
    if (!r) r = derive(b, l + 1);
    if (!r) r = fn_ty(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean string_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_lit")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, STRING_LIT, r);
    return r;
  }

  /* ********************************************************** */
  // doc_attr 'struct' ident (tuple_struct_tail | block_fields | ';')
  public static boolean struct_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_def")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DEF, "<struct def>");
    r = doc_attr(b, l + 1);
    r = r && consumeTokens(b, 0, STRUCT_KW, IDENT);
    r = r && struct_def_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // tuple_struct_tail | block_fields | ';'
  private static boolean struct_def_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "struct_def_3")) return false;
    boolean r;
    r = tuple_struct_tail(b, l + 1);
    if (!r) r = block_fields(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // 'char' | 'str'
  public static boolean textual_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "textual_ty")) return false;
    if (!nextTokenIs(b, "<textual ty>", CHAR, STR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXTUAL_TY, "<textual ty>");
    r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, STR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !('struct' | 'enum' | 'type' | 'rs' | 'const' | doc_attr)
  static boolean top_level_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !top_level_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'struct' | 'enum' | 'type' | 'rs' | 'const' | doc_attr
  private static boolean top_level_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_recover_0")) return false;
    boolean r;
    r = consumeToken(b, STRUCT_KW);
    if (!r) r = consumeToken(b, ENUM_KW);
    if (!r) r = consumeToken(b, TYPE_KW);
    if (!r) r = consumeToken(b, RS_KW);
    if (!r) r = consumeToken(b, CONST_KW);
    if (!r) r = doc_attr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !')' ty (',' | &')')
  static boolean tuple_field_decl_with_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_field_decl_with_recover")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = tuple_field_decl_with_recover_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, ty(b, l + 1));
    r = p && tuple_field_decl_with_recover_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !')'
  private static boolean tuple_field_decl_with_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_field_decl_with_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ',' | &')'
  private static boolean tuple_field_decl_with_recover_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_field_decl_with_recover_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = tuple_field_decl_with_recover_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &')'
  private static boolean tuple_field_decl_with_recover_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_field_decl_with_recover_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // tuple_ty ';'
  static boolean tuple_struct_tail(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_struct_tail")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = tuple_ty(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '(' tuple_field_decl_with_recover* ')'
  public static boolean tuple_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_ty")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_TY, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, tuple_ty_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // tuple_field_decl_with_recover*
  private static boolean tuple_ty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_ty_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tuple_field_decl_with_recover(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_ty_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // standard_ty | (path generics?)
  public static boolean ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TY, "<ty>");
    r = standard_ty(b, l + 1);
    if (!r) r = ty_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path generics?
  private static boolean ty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ty_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path(b, l + 1);
    r = r && ty_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // generics?
  private static boolean ty_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ty_1_1")) return false;
    generics(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'type' ident '=' ty ';'
  public static boolean type_alias_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_alias_stmt")) return false;
    if (!nextTokenIs(b, TYPE_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ALIAS_STMT, null);
    r = consumeTokens(b, 3, TYPE_KW, IDENT, EQ);
    p = r; // pin = 3
    r = r && report_error_(b, ty(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ':' ty
  public static boolean type_ascription(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ascription")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ASCRIPTION, null);
    r = consumeToken(b, COLON);
    p = r; // pin = 1
    r = r && ty(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '`' expr '`'
  public static boolean unit_expr_ticked(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_expr_ticked")) return false;
    if (!nextTokenIs(b, BACKTICK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BACKTICK);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, BACKTICK);
    exit_section_(b, m, UNIT_EXPR_TICKED, r);
    return r;
  }

  /* ********************************************************** */
  // 'const' | 'rw' | 'ro' | 'wo'
  public static boolean xpi_access_mode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_access_mode")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XPI_ACCESS_MODE, "<xpi access mode>");
    r = consumeToken(b, CONST_KW);
    if (!r) r = consumeToken(b, RW_KW);
    if (!r) r = consumeToken(b, RO_KW);
    if (!r) r = consumeToken(b, WO_KW);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // doc_attr ('rs' | 'trait') xpi_uri_segment xpi_resource_ty? xpi_body?
  public static boolean xpi_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_block")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XPI_BLOCK, "<xpi block>");
    r = doc_attr(b, l + 1);
    r = r && xpi_block_1(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, xpi_uri_segment(b, l + 1));
    r = p && report_error_(b, xpi_block_3(b, l + 1)) && r;
    r = p && xpi_block_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'rs' | 'trait'
  private static boolean xpi_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_block_1")) return false;
    boolean r;
    r = consumeToken(b, RS_KW);
    if (!r) r = consumeToken(b, TRAIT_KW);
    return r;
  }

  // xpi_resource_ty?
  private static boolean xpi_block_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_block_3")) return false;
    xpi_resource_ty(b, l + 1);
    return true;
  }

  // xpi_body?
  private static boolean xpi_block_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_block_4")) return false;
    xpi_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '{' xpi_item_with_recover* '}'
  public static boolean xpi_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_body")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XPI_BODY, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, xpi_body_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // xpi_item_with_recover*
  private static boolean xpi_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xpi_item_with_recover(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xpi_body_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ident ':' expr ';'
  public static boolean xpi_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_field")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XPI_FIELD, null);
    r = consumeTokens(b, 2, IDENT, COLON);
    p = r; // pin = 2
    r = r && report_error_(b, expr(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'impl' expr ';'
  public static boolean xpi_impl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_impl")) return false;
    if (!nextTokenIs(b, IMPL_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XPI_IMPL, null);
    r = consumeToken(b, IMPL_KW);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !('}' | (ident ':') | 'rs' | 'impl' | doc_attr)
  public static boolean xpi_item_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_item_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, XPI_ITEM_RECOVER, "<xpi item recover>");
    r = !xpi_item_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}' | (ident ':') | 'rs' | 'impl' | doc_attr
  private static boolean xpi_item_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_item_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RBRACE);
    if (!r) r = xpi_item_recover_0_1(b, l + 1);
    if (!r) r = consumeToken(b, RS_KW);
    if (!r) r = consumeToken(b, IMPL_KW);
    if (!r) r = doc_attr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ident ':'
  private static boolean xpi_item_recover_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_item_recover_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !"}" (xpi_block | xpi_field | xpi_impl)
  public static boolean xpi_item_with_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_item_with_recover")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XPI_ITEM_WITH_RECOVER, "<xpi item with recover>");
    r = xpi_item_with_recover_0(b, l + 1);
    p = r; // pin = 1
    r = r && xpi_item_with_recover_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !"}"
  private static boolean xpi_item_with_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_item_with_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // xpi_block | xpi_field | xpi_impl
  private static boolean xpi_item_with_recover_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_item_with_recover_1")) return false;
    boolean r;
    r = xpi_block(b, l + 1);
    if (!r) r = xpi_field(b, l + 1);
    if (!r) r = xpi_impl(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'observe'
  public static boolean xpi_mod_observe(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_mod_observe")) return false;
    if (!nextTokenIs(b, OBSERVE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OBSERVE_KW);
    exit_section_(b, m, XPI_MOD_OBSERVE, r);
    return r;
  }

  /* ********************************************************** */
  // 'stream'
  public static boolean xpi_mod_stream(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_mod_stream")) return false;
    if (!nextTokenIs(b, STREAM_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STREAM_KW);
    exit_section_(b, m, XPI_MOD_STREAM, r);
    return r;
  }

  /* ********************************************************** */
  // 'Cell' '<' xpi_resource_transform? ty '>'
  public static boolean xpi_resource_cell_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_cell_ty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XPI_RESOURCE_CELL_TY, "<xpi resource cell ty>");
    r = consumeToken(b, "Cell");
    r = r && consumeToken(b, LT);
    r = r && xpi_resource_cell_ty_2(b, l + 1);
    r = r && ty(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // xpi_resource_transform?
  private static boolean xpi_resource_cell_ty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_cell_ty_2")) return false;
    xpi_resource_transform(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // xpi_access_mode  ('+' xpi_mod_stream | '+' xpi_mod_observe)?
  public static boolean xpi_resource_transform(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_transform")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XPI_RESOURCE_TRANSFORM, "<xpi resource transform>");
    r = xpi_access_mode(b, l + 1);
    r = r && xpi_resource_transform_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('+' xpi_mod_stream | '+' xpi_mod_observe)?
  private static boolean xpi_resource_transform_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_transform_1")) return false;
    xpi_resource_transform_1_0(b, l + 1);
    return true;
  }

  // '+' xpi_mod_stream | '+' xpi_mod_observe
  private static boolean xpi_resource_transform_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_transform_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xpi_resource_transform_1_0_0(b, l + 1);
    if (!r) r = xpi_resource_transform_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' xpi_mod_stream
  private static boolean xpi_resource_transform_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_transform_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && xpi_mod_stream(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' xpi_mod_observe
  private static boolean xpi_resource_transform_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_transform_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && xpi_mod_observe(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<' (xpi_resource_transform? (xpi_resource_cell_ty | ty))? (',' xpi_serial ('..=' xpi_serial)? )? '>'
  public static boolean xpi_resource_ty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, XPI_RESOURCE_TY, "<xpi resource ty>");
    r = consumeToken(b, LT);
    p = r; // pin = 1
    r = r && report_error_(b, xpi_resource_ty_1(b, l + 1));
    r = p && report_error_(b, xpi_resource_ty_2(b, l + 1)) && r;
    r = p && consumeToken(b, GT) && r;
    exit_section_(b, l, m, r, p, VhlParser::xpi_resource_ty_recover);
    return r || p;
  }

  // (xpi_resource_transform? (xpi_resource_cell_ty | ty))?
  private static boolean xpi_resource_ty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_1")) return false;
    xpi_resource_ty_1_0(b, l + 1);
    return true;
  }

  // xpi_resource_transform? (xpi_resource_cell_ty | ty)
  private static boolean xpi_resource_ty_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xpi_resource_ty_1_0_0(b, l + 1);
    r = r && xpi_resource_ty_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // xpi_resource_transform?
  private static boolean xpi_resource_ty_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_1_0_0")) return false;
    xpi_resource_transform(b, l + 1);
    return true;
  }

  // xpi_resource_cell_ty | ty
  private static boolean xpi_resource_ty_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_1_0_1")) return false;
    boolean r;
    r = xpi_resource_cell_ty(b, l + 1);
    if (!r) r = ty(b, l + 1);
    return r;
  }

  // (',' xpi_serial ('..=' xpi_serial)? )?
  private static boolean xpi_resource_ty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_2")) return false;
    xpi_resource_ty_2_0(b, l + 1);
    return true;
  }

  // ',' xpi_serial ('..=' xpi_serial)?
  private static boolean xpi_resource_ty_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && xpi_serial(b, l + 1);
    r = r && xpi_resource_ty_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('..=' xpi_serial)?
  private static boolean xpi_resource_ty_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_2_0_2")) return false;
    xpi_resource_ty_2_0_2_0(b, l + 1);
    return true;
  }

  // '..=' xpi_serial
  private static boolean xpi_resource_ty_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOTDOTEQ);
    r = r && xpi_serial(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !('{')
  public static boolean xpi_resource_ty_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_resource_ty_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, XPI_RESOURCE_TY_RECOVER, "<xpi resource ty recover>");
    r = !consumeToken(b, LBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '#' DEC_LIT_RAW
  public static boolean xpi_serial(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_serial")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, HASH, DEC_LIT_RAW);
    exit_section_(b, m, XPI_SERIAL, r);
    return r;
  }

  /* ********************************************************** */
  // (ident expr_ticked? (ident_continue | ident)?) | (expr_ticked (ident_continue | ident)?)
  public static boolean xpi_uri_segment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment")) return false;
    if (!nextTokenIs(b, "<xpi uri segment>", BACKTICK, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XPI_URI_SEGMENT, "<xpi uri segment>");
    r = xpi_uri_segment_0(b, l + 1);
    if (!r) r = xpi_uri_segment_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ident expr_ticked? (ident_continue | ident)?
  private static boolean xpi_uri_segment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && xpi_uri_segment_0_1(b, l + 1);
    r = r && xpi_uri_segment_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr_ticked?
  private static boolean xpi_uri_segment_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment_0_1")) return false;
    expr_ticked(b, l + 1);
    return true;
  }

  // (ident_continue | ident)?
  private static boolean xpi_uri_segment_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment_0_2")) return false;
    xpi_uri_segment_0_2_0(b, l + 1);
    return true;
  }

  // ident_continue | ident
  private static boolean xpi_uri_segment_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment_0_2_0")) return false;
    boolean r;
    r = consumeToken(b, IDENT_CONTINUE);
    if (!r) r = consumeToken(b, IDENT);
    return r;
  }

  // expr_ticked (ident_continue | ident)?
  private static boolean xpi_uri_segment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr_ticked(b, l + 1);
    r = r && xpi_uri_segment_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ident_continue | ident)?
  private static boolean xpi_uri_segment_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment_1_1")) return false;
    xpi_uri_segment_1_1_0(b, l + 1);
    return true;
  }

  // ident_continue | ident
  private static boolean xpi_uri_segment_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpi_uri_segment_1_1_0")) return false;
    boolean r;
    r = consumeToken(b, IDENT_CONTINUE);
    if (!r) r = consumeToken(b, IDENT);
    return r;
  }

}
