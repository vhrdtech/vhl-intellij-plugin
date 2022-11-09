// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import tech.vhrd.vhl.lexer.VhlTokenType;
import tech.vhrd.vhl.psi.impl.*;

public interface VhlTypes {

  IElementType ARRAY_LIT = new VhlElementType("ARRAY_LIT");
  IElementType ARRAY_TY = new VhlElementType("ARRAY_TY");
  IElementType ATTRIBUTE = new VhlElementType("ATTRIBUTE");
  IElementType ATTRIBUTE_INPUT = new VhlElementType("ATTRIBUTE_INPUT");
  IElementType BIN_OP = new VhlElementType("BIN_OP");
  IElementType BLOCK_FIELDS = new VhlElementType("BLOCK_FIELDS");
  IElementType BOOL_LIT = new VhlElementType("BOOL_LIT");
  IElementType BOOL_TY = new VhlElementType("BOOL_TY");
  IElementType CALL_ARGUMENTS = new VhlElementType("CALL_ARGUMENTS");
  IElementType CALL_EXPR = new VhlElementType("CALL_EXPR");
  IElementType CHAR_LIT = new VhlElementType("CHAR_LIT");
  IElementType DERIVE = new VhlElementType("DERIVE");
  IElementType DISCRETE_LIT = new VhlElementType("DISCRETE_LIT");
  IElementType DISCRETE_SIGNED_TY = new VhlElementType("DISCRETE_SIGNED_TY");
  IElementType DISCRETE_TY = new VhlElementType("DISCRETE_TY");
  IElementType DISCRETE_UNSIGNED_TY = new VhlElementType("DISCRETE_UNSIGNED_TY");
  IElementType ENUM_DEF = new VhlElementType("ENUM_DEF");
  IElementType ENUM_ITEM = new VhlElementType("ENUM_ITEM");
  IElementType ENUM_ITEM_DISCRIMINANT = new VhlElementType("ENUM_ITEM_DISCRIMINANT");
  IElementType EXPR = new VhlElementType("EXPR");
  IElementType EXPR_LIST = new VhlElementType("EXPR_LIST");
  IElementType EXPR_TICKED = new VhlElementType("EXPR_TICKED");
  IElementType FIXED_SIGNED_TY = new VhlElementType("FIXED_SIGNED_TY");
  IElementType FIXED_TY = new VhlElementType("FIXED_TY");
  IElementType FIXED_UNSIGNED_TY = new VhlElementType("FIXED_UNSIGNED_TY");
  IElementType FLOATING_TY = new VhlElementType("FLOATING_TY");
  IElementType FLOAT_LIT = new VhlElementType("FLOAT_LIT");
  IElementType FN_ARG = new VhlElementType("FN_ARG");
  IElementType FN_ARGS = new VhlElementType("FN_ARGS");
  IElementType FN_RET_TY = new VhlElementType("FN_RET_TY");
  IElementType FN_TY = new VhlElementType("FN_TY");
  IElementType GENERICS = new VhlElementType("GENERICS");
  IElementType GENERIC_PARAM = new VhlElementType("GENERIC_PARAM");
  IElementType INDEX_ARGUMENTS = new VhlElementType("INDEX_ARGUMENTS");
  IElementType INDEX_INTO_EXPR = new VhlElementType("INDEX_INTO_EXPR");
  IElementType INNER_ATTR = new VhlElementType("INNER_ATTR");
  IElementType ITEM = new VhlElementType("ITEM");
  IElementType LIT = new VhlElementType("LIT");
  IElementType NAMED_FIELD_DECL = new VhlElementType("NAMED_FIELD_DECL");
  IElementType NUMBER_LIT = new VhlElementType("NUMBER_LIT");
  IElementType NUM_BOUND = new VhlElementType("NUM_BOUND");
  IElementType NUM_BOUND_BRACED = new VhlElementType("NUM_BOUND_BRACED");
  IElementType NUM_BOUND_LIST = new VhlElementType("NUM_BOUND_LIST");
  IElementType NUM_BOUND_MAX = new VhlElementType("NUM_BOUND_MAX");
  IElementType NUM_BOUND_MIN = new VhlElementType("NUM_BOUND_MIN");
  IElementType NUM_UNBOUND = new VhlElementType("NUM_UNBOUND");
  IElementType OUTER_ATTR = new VhlElementType("OUTER_ATTR");
  IElementType PATH = new VhlElementType("PATH");
  IElementType STRING_LIT = new VhlElementType("STRING_LIT");
  IElementType STRUCT_DEF = new VhlElementType("STRUCT_DEF");
  IElementType TEXTUAL_TY = new VhlElementType("TEXTUAL_TY");
  IElementType TUPLE_TY = new VhlElementType("TUPLE_TY");
  IElementType TY = new VhlElementType("TY");
  IElementType TYPE_ALIAS_STMT = new VhlElementType("TYPE_ALIAS_STMT");
  IElementType TYPE_ASCRIPTION = new VhlElementType("TYPE_ASCRIPTION");
  IElementType UNIT_EXPR_TICKED = new VhlElementType("UNIT_EXPR_TICKED");
  IElementType XPI_ACCESS_MODE = new VhlElementType("XPI_ACCESS_MODE");
  IElementType XPI_BLOCK = new VhlElementType("XPI_BLOCK");
  IElementType XPI_BODY = new VhlElementType("XPI_BODY");
  IElementType XPI_FIELD = new VhlElementType("XPI_FIELD");
  IElementType XPI_IMPL = new VhlElementType("XPI_IMPL");
  IElementType XPI_ITEM_RECOVER = new VhlElementType("XPI_ITEM_RECOVER");
  IElementType XPI_ITEM_WITH_RECOVER = new VhlElementType("XPI_ITEM_WITH_RECOVER");
  IElementType XPI_MOD_OBSERVE = new VhlElementType("XPI_MOD_OBSERVE");
  IElementType XPI_MOD_STREAM = new VhlElementType("XPI_MOD_STREAM");
  IElementType XPI_RESOURCE_CELL_TY = new VhlElementType("XPI_RESOURCE_CELL_TY");
  IElementType XPI_RESOURCE_TRANSFORM = new VhlElementType("XPI_RESOURCE_TRANSFORM");
  IElementType XPI_RESOURCE_TY = new VhlElementType("XPI_RESOURCE_TY");
  IElementType XPI_RESOURCE_TY_RECOVER = new VhlElementType("XPI_RESOURCE_TY_RECOVER");
  IElementType XPI_SERIAL = new VhlElementType("XPI_SERIAL");
  IElementType XPI_URI_SEGMENT = new VhlElementType("XPI_URI_SEGMENT");

  IElementType AND = new VhlTokenType("&");
  IElementType ANDAND = new VhlTokenType("&&");
  IElementType BACKTICK = new VhlTokenType("`");
  IElementType BIN_LIT_RAW = new VhlTokenType("BIN_LIT_RAW");
  IElementType BLOCK_COMMENT = new VhlTokenType("block_comment_lx");
  IElementType BOOL = new VhlTokenType("bool");
  IElementType BOUND = new VhlTokenType("@");
  IElementType CHAR = new VhlTokenType("char");
  IElementType CHAR_LITERAL = new VhlTokenType("CHAR_LITERAL");
  IElementType COLON = new VhlTokenType(":");
  IElementType COLONCOLON = new VhlTokenType("::");
  IElementType COMMA = new VhlTokenType(",");
  IElementType CONST_KW = new VhlTokenType("const");
  IElementType DEC_LIT_RAW = new VhlTokenType("DEC_LIT_RAW");
  IElementType DISCRETE_SIGNED_TY_IMPLICIT = new VhlTokenType("DISCRETE_SIGNED_TY_IMPLICIT");
  IElementType DISCRETE_UNSIGNED_TY_IMPLICIT = new VhlTokenType("DISCRETE_UNSIGNED_TY_IMPLICIT");
  IElementType DIV = new VhlTokenType("/");
  IElementType DOT = new VhlTokenType(".");
  IElementType DOTDOT = new VhlTokenType("..");
  IElementType DOTDOTDOT = new VhlTokenType("...");
  IElementType DOTDOTEQ = new VhlTokenType("..=");
  IElementType ENUM_KW = new VhlTokenType("enum");
  IElementType ENUM_LIT = new VhlTokenType("enum_lit");
  IElementType EOL_COMMENT = new VhlTokenType("eol_comment_lx");
  IElementType EQ = new VhlTokenType("=");
  IElementType EQEQ = new VhlTokenType("==");
  IElementType EXCL = new VhlTokenType("!");
  IElementType EXCLEQ = new VhlTokenType("!=");
  IElementType EXPRESSION_PARENTHESIZED = new VhlTokenType("expression_parenthesized");
  IElementType FALSE = new VhlTokenType("false");
  IElementType FIXED_SIGNED_TY_IMPLICIT = new VhlTokenType("FIXED_SIGNED_TY_IMPLICIT");
  IElementType FIXED_UNSIGNED_TY_IMPLICIT = new VhlTokenType("FIXED_UNSIGNED_TY_IMPLICIT");
  IElementType FLOAT_LIT_RAW = new VhlTokenType("FLOAT_LIT_RAW");
  IElementType FLOAT_TY_IMPLICIT = new VhlTokenType("FLOAT_TY_IMPLICIT");
  IElementType FN_KW = new VhlTokenType("fn");
  IElementType GT = new VhlTokenType(">");
  IElementType HASH = new VhlTokenType("#");
  IElementType HEX_LIT_RAW = new VhlTokenType("HEX_LIT_RAW");
  IElementType IDENT = new VhlTokenType("ident");
  IElementType IDENT_CONTINUE = new VhlTokenType("ident_continue");
  IElementType IMPL_KW = new VhlTokenType("impl");
  IElementType INNER_BLOCK_DOC_COMMENT = new VhlTokenType("INNER_BLOCK_DOC_COMMENT");
  IElementType INNER_EOL_DOC_COMMENT = new VhlTokenType("INNER_EOL_DOC_COMMENT");
  IElementType LBRACE = new VhlTokenType("{");
  IElementType LBRACK = new VhlTokenType("[");
  IElementType LPAREN = new VhlTokenType("(");
  IElementType LT = new VhlTokenType("<");
  IElementType MAX_BOUND = new VhlTokenType("max");
  IElementType MINUS = new VhlTokenType("-");
  IElementType MIN_BOUND = new VhlTokenType("min");
  IElementType MUL = new VhlTokenType("*");
  IElementType OBSERVE_KW = new VhlTokenType("observe");
  IElementType OCT_LIT_RAW = new VhlTokenType("OCT_LIT_RAW");
  IElementType OR = new VhlTokenType("|");
  IElementType OROR = new VhlTokenType("||");
  IElementType OUTER_BLOCK_DOC_COMMENT = new VhlTokenType("OUTER_BLOCK_DOC_COMMENT");
  IElementType OUTER_EOL_DOC_COMMENT = new VhlTokenType("OUTER_EOL_DOC_COMMENT");
  IElementType PLUS = new VhlTokenType("+");
  IElementType RBRACE = new VhlTokenType("}");
  IElementType RBRACK = new VhlTokenType("]");
  IElementType REM = new VhlTokenType("%");
  IElementType RO_KW = new VhlTokenType("ro");
  IElementType RPAREN = new VhlTokenType(")");
  IElementType RS_KW = new VhlTokenType("rs");
  IElementType RW_KW = new VhlTokenType("rw");
  IElementType SEMICOLON = new VhlTokenType(";");
  IElementType STR = new VhlTokenType("str");
  IElementType STREAM_KW = new VhlTokenType("stream");
  IElementType STRING_LITERAL = new VhlTokenType("STRING_LITERAL");
  IElementType STRUCT_KW = new VhlTokenType("struct");
  IElementType STRUCT_LIT = new VhlTokenType("struct_lit");
  IElementType TRAIT_KW = new VhlTokenType("trait");
  IElementType TRUE = new VhlTokenType("true");
  IElementType TUPLE_LIT = new VhlTokenType("tuple_lit");
  IElementType TUPLE_OF_EXPRESSIONS = new VhlTokenType("tuple_of_expressions");
  IElementType TYPE_KW = new VhlTokenType("type");
  IElementType UNARY_EXPR = new VhlTokenType("unary_expr");
  IElementType UNBOUND = new VhlTokenType("?");
  IElementType UNDERSCORE = new VhlTokenType("_");
  IElementType WO_KW = new VhlTokenType("wo");
  IElementType XOR = new VhlTokenType("^");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_LIT) {
        return new VhlArrayLitImpl(node);
      }
      else if (type == ARRAY_TY) {
        return new VhlArrayTyImpl(node);
      }
      else if (type == ATTRIBUTE) {
        return new VhlAttributeImpl(node);
      }
      else if (type == ATTRIBUTE_INPUT) {
        return new VhlAttributeInputImpl(node);
      }
      else if (type == BIN_OP) {
        return new VhlBinOpImpl(node);
      }
      else if (type == BLOCK_FIELDS) {
        return new VhlBlockFieldsImpl(node);
      }
      else if (type == BOOL_LIT) {
        return new VhlBoolLitImpl(node);
      }
      else if (type == BOOL_TY) {
        return new VhlBoolTyImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new VhlCallArgumentsImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new VhlCallExprImpl(node);
      }
      else if (type == CHAR_LIT) {
        return new VhlCharLitImpl(node);
      }
      else if (type == DERIVE) {
        return new VhlDeriveImpl(node);
      }
      else if (type == DISCRETE_LIT) {
        return new VhlDiscreteLitImpl(node);
      }
      else if (type == DISCRETE_SIGNED_TY) {
        return new VhlDiscreteSignedTyImpl(node);
      }
      else if (type == DISCRETE_TY) {
        return new VhlDiscreteTyImpl(node);
      }
      else if (type == DISCRETE_UNSIGNED_TY) {
        return new VhlDiscreteUnsignedTyImpl(node);
      }
      else if (type == ENUM_DEF) {
        return new VhlEnumDefImpl(node);
      }
      else if (type == ENUM_ITEM) {
        return new VhlEnumItemImpl(node);
      }
      else if (type == ENUM_ITEM_DISCRIMINANT) {
        return new VhlEnumItemDiscriminantImpl(node);
      }
      else if (type == EXPR) {
        return new VhlExprImpl(node);
      }
      else if (type == EXPR_LIST) {
        return new VhlExprListImpl(node);
      }
      else if (type == EXPR_TICKED) {
        return new VhlExprTickedImpl(node);
      }
      else if (type == FIXED_SIGNED_TY) {
        return new VhlFixedSignedTyImpl(node);
      }
      else if (type == FIXED_TY) {
        return new VhlFixedTyImpl(node);
      }
      else if (type == FIXED_UNSIGNED_TY) {
        return new VhlFixedUnsignedTyImpl(node);
      }
      else if (type == FLOATING_TY) {
        return new VhlFloatingTyImpl(node);
      }
      else if (type == FLOAT_LIT) {
        return new VhlFloatLitImpl(node);
      }
      else if (type == FN_ARG) {
        return new VhlFnArgImpl(node);
      }
      else if (type == FN_ARGS) {
        return new VhlFnArgsImpl(node);
      }
      else if (type == FN_RET_TY) {
        return new VhlFnRetTyImpl(node);
      }
      else if (type == FN_TY) {
        return new VhlFnTyImpl(node);
      }
      else if (type == GENERICS) {
        return new VhlGenericsImpl(node);
      }
      else if (type == GENERIC_PARAM) {
        return new VhlGenericParamImpl(node);
      }
      else if (type == INDEX_ARGUMENTS) {
        return new VhlIndexArgumentsImpl(node);
      }
      else if (type == INDEX_INTO_EXPR) {
        return new VhlIndexIntoExprImpl(node);
      }
      else if (type == INNER_ATTR) {
        return new VhlInnerAttrImpl(node);
      }
      else if (type == ITEM) {
        return new VhlItemImpl(node);
      }
      else if (type == LIT) {
        return new VhlLitImpl(node);
      }
      else if (type == NAMED_FIELD_DECL) {
        return new VhlNamedFieldDeclImpl(node);
      }
      else if (type == NUMBER_LIT) {
        return new VhlNumberLitImpl(node);
      }
      else if (type == NUM_BOUND) {
        return new VhlNumBoundImpl(node);
      }
      else if (type == NUM_BOUND_BRACED) {
        return new VhlNumBoundBracedImpl(node);
      }
      else if (type == NUM_BOUND_LIST) {
        return new VhlNumBoundListImpl(node);
      }
      else if (type == NUM_BOUND_MAX) {
        return new VhlNumBoundMaxImpl(node);
      }
      else if (type == NUM_BOUND_MIN) {
        return new VhlNumBoundMinImpl(node);
      }
      else if (type == NUM_UNBOUND) {
        return new VhlNumUnboundImpl(node);
      }
      else if (type == OUTER_ATTR) {
        return new VhlOuterAttrImpl(node);
      }
      else if (type == PATH) {
        return new VhlPathImpl(node);
      }
      else if (type == STRING_LIT) {
        return new VhlStringLitImpl(node);
      }
      else if (type == STRUCT_DEF) {
        return new VhlStructDefImpl(node);
      }
      else if (type == TEXTUAL_TY) {
        return new VhlTextualTyImpl(node);
      }
      else if (type == TUPLE_TY) {
        return new VhlTupleTyImpl(node);
      }
      else if (type == TY) {
        return new VhlTyImpl(node);
      }
      else if (type == TYPE_ALIAS_STMT) {
        return new VhlTypeAliasStmtImpl(node);
      }
      else if (type == TYPE_ASCRIPTION) {
        return new VhlTypeAscriptionImpl(node);
      }
      else if (type == UNIT_EXPR_TICKED) {
        return new VhlUnitExprTickedImpl(node);
      }
      else if (type == XPI_ACCESS_MODE) {
        return new VhlXpiAccessModeImpl(node);
      }
      else if (type == XPI_BLOCK) {
        return new VhlXpiBlockImpl(node);
      }
      else if (type == XPI_BODY) {
        return new VhlXpiBodyImpl(node);
      }
      else if (type == XPI_FIELD) {
        return new VhlXpiFieldImpl(node);
      }
      else if (type == XPI_IMPL) {
        return new VhlXpiImplImpl(node);
      }
      else if (type == XPI_ITEM_RECOVER) {
        return new VhlXpiItemRecoverImpl(node);
      }
      else if (type == XPI_ITEM_WITH_RECOVER) {
        return new VhlXpiItemWithRecoverImpl(node);
      }
      else if (type == XPI_MOD_OBSERVE) {
        return new VhlXpiModObserveImpl(node);
      }
      else if (type == XPI_MOD_STREAM) {
        return new VhlXpiModStreamImpl(node);
      }
      else if (type == XPI_RESOURCE_CELL_TY) {
        return new VhlXpiResourceCellTyImpl(node);
      }
      else if (type == XPI_RESOURCE_TRANSFORM) {
        return new VhlXpiResourceTransformImpl(node);
      }
      else if (type == XPI_RESOURCE_TY) {
        return new VhlXpiResourceTyImpl(node);
      }
      else if (type == XPI_RESOURCE_TY_RECOVER) {
        return new VhlXpiResourceTyRecoverImpl(node);
      }
      else if (type == XPI_SERIAL) {
        return new VhlXpiSerialImpl(node);
      }
      else if (type == XPI_URI_SEGMENT) {
        return new VhlXpiUriSegmentImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
