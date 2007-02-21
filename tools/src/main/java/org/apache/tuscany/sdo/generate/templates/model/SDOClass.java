package org.apache.tuscany.sdo.generate.templates.model;

import org.eclipse.emf.codegen.util.*;
import org.apache.tuscany.sdo.impl.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.apache.tuscany.sdo.generate.util.*;

public class SDOClass
{
  protected static String nl;
  public static synchronized SDOClass create(String lineSeparator)
  {
    nl = lineSeparator;
    SDOClass result = new SDOClass();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/**" + NL + " * <copyright>" + NL + " * </copyright>" + NL + " *" + NL + " * ";
  protected final String TEXT_3 = "Id";
  protected final String TEXT_4 = NL + " */";
  protected final String TEXT_5 = NL + "package ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "package ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "  // EYECATCHER 1";
  protected final String TEXT_12 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A representation of the model object '<em><b>";
  protected final String TEXT_13 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_14 = NL + " *" + NL + " * <!-- begin-model-doc -->" + NL + " * ";
  protected final String TEXT_15 = NL + " * <!-- end-model-doc -->";
  protected final String TEXT_16 = NL + " *";
  protected final String TEXT_17 = NL + " * <p>" + NL + " * The following features are supported:" + NL + " * <ul>";
  protected final String TEXT_18 = NL + "// debug EYECATCHER 2";
  protected final String TEXT_19 = NL + " *   <li>{@link ";
  protected final String TEXT_20 = "#";
  protected final String TEXT_21 = " <em>";
  protected final String TEXT_22 = "</em>}</li>";
  protected final String TEXT_23 = NL + " * </ul>" + NL + " * </p>";
  protected final String TEXT_24 = NL + " *";
  protected final String TEXT_25 = NL + " * @see ";
  protected final String TEXT_26 = "#get";
  protected final String TEXT_27 = "()";
  protected final String TEXT_28 = NL + " * @model ";
  protected final String TEXT_29 = NL + " *        ";
  protected final String TEXT_30 = NL + " * @model";
  protected final String TEXT_31 = NL + " * @extends ";
  protected final String TEXT_32 = NL + " * @generated" + NL + " */";
  protected final String TEXT_33 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model object '<em><b>";
  protected final String TEXT_34 = "</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>";
  protected final String TEXT_35 = NL + " * The following features are implemented:" + NL + " * <ul>";
  protected final String TEXT_36 = NL + " *   <li>{@link ";
  protected final String TEXT_37 = "#";
  protected final String TEXT_38 = " <em>";
  protected final String TEXT_39 = "</em>}</li>";
  protected final String TEXT_40 = NL + " * </ul>";
  protected final String TEXT_41 = NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */";
  protected final String TEXT_42 = NL + "public";
  protected final String TEXT_43 = " abstract";
  protected final String TEXT_44 = " class ";
  protected final String TEXT_45 = NL + "public interface ";
  protected final String TEXT_46 = NL + "{";
  protected final String TEXT_47 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_48 = " copyright = \"";
  protected final String TEXT_49 = "\";";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_52 = " mofDriverNumber = \"";
  protected final String TEXT_53 = "\";";
  protected final String TEXT_54 = NL;
  protected final String TEXT_55 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL;
  protected final String TEXT_56 = NL + "\t/**" + NL + "\t * An array of objects representing the values of non-primitive features." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] ";
  protected final String TEXT_57 = " = null;" + NL;
  protected final String TEXT_58 = NL + "\t/**" + NL + "\t * A bit field representing the indices of non-primitive feature values." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_59 = " = 0;" + NL;
  protected final String TEXT_60 = NL + "\t/**" + NL + "\t * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_61 = " = 0;" + NL;
  protected final String TEXT_62 = NL;
  protected final String TEXT_63 = NL + "\tpublic final static int ";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = ";" + NL;
  protected final String TEXT_66 = NL + "\tpublic final static int ";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ";" + NL;
  protected final String TEXT_69 = NL + "\tpublic final static int SDO_PROPERTY_COUNT = ";
  protected final String TEXT_70 = ";" + NL;
  protected final String TEXT_71 = NL + "\tpublic final static int EXTENDED_PROPERTY_COUNT = ";
  protected final String TEXT_72 = ";" + NL + NL;
  protected final String TEXT_73 = NL + "\t/**" + NL + "\t * The internal feature id for the '<em><b>";
  protected final String TEXT_74 = "</b></em>' ";
  protected final String TEXT_75 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_76 = " " + NL + "\tpublic final static int INTERNAL_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ";" + NL;
  protected final String TEXT_79 = NL + "\t/**" + NL + "\t * The number of properties for this type." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_80 = NL + "\tpublic final static int INTERNAL_PROPERTY_COUNT = ";
  protected final String TEXT_81 = ";" + NL + "" + NL + "\tprotected int internalConvertIndex(int internalIndex)" + NL + "\t{" + NL + "\t\tswitch (internalIndex)" + NL + "\t\t{";
  protected final String TEXT_82 = NL + "\t\t\tcase INTERNAL_";
  protected final String TEXT_83 = ": return ";
  protected final String TEXT_84 = ";";
  protected final String TEXT_85 = NL + "\t\t}" + NL + "\t\treturn super.internalConvertIndex(internalIndex);" + NL + "\t}" + NL + NL;
  protected final String TEXT_86 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_87 = "() <em>";
  protected final String TEXT_88 = "</em>}' ";
  protected final String TEXT_89 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_90 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t" + NL + "\tprotected ";
  protected final String TEXT_91 = " ";
  protected final String TEXT_92 = " = null;" + NL + "\t";
  protected final String TEXT_93 = NL + "\t/**" + NL + "\t * The empty value for the '{@link #";
  protected final String TEXT_94 = "() <em>";
  protected final String TEXT_95 = "</em>}' array accessor." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_96 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_97 = "[] ";
  protected final String TEXT_98 = "_EEMPTY_ARRAY = new ";
  protected final String TEXT_99 = " [0];" + NL;
  protected final String TEXT_100 = NL + "\t/**" + NL + "\t * The default value of the '{@link #";
  protected final String TEXT_101 = "() <em>";
  protected final String TEXT_102 = "</em>}' ";
  protected final String TEXT_103 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_104 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_105 = " ";
  protected final String TEXT_106 = "_DEFAULT_ = ";
  protected final String TEXT_107 = ";";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_110 = " = 0;" + NL;
  protected final String TEXT_111 = NL + "\t/**" + NL + "\t * The flag representing the value of the '{@link #";
  protected final String TEXT_112 = "() <em>";
  protected final String TEXT_113 = "</em>}' ";
  protected final String TEXT_114 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_115 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_116 = "_EFLAG = 1 ";
  protected final String TEXT_117 = ";" + NL;
  protected final String TEXT_118 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_119 = "() <em>";
  protected final String TEXT_120 = "</em>}' ";
  protected final String TEXT_121 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_122 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_123 = " ";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = "_DEFAULT_;" + NL;
  protected final String TEXT_126 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_127 = " = 0;" + NL;
  protected final String TEXT_128 = NL + "\t/**" + NL + "\t * The flag representing whether the ";
  protected final String TEXT_129 = " ";
  protected final String TEXT_130 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_131 = "_ESETFLAG = 1 ";
  protected final String TEXT_132 = ";" + NL;
  protected final String TEXT_133 = NL + "\t/**" + NL + "\t * This is true if the ";
  protected final String TEXT_134 = " ";
  protected final String TEXT_135 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected boolean ";
  protected final String TEXT_136 = "_set_ = false;" + NL;
  protected final String TEXT_137 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_138 = "()" + NL + "\t{" + NL + "\t\tsuper();";
  protected final String TEXT_139 = NL + "\t\t";
  protected final String TEXT_140 = " |= ";
  protected final String TEXT_141 = "_EFLAG;";
  protected final String TEXT_142 = NL + "\t\tcreateChangeSummary(";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_145 = " getType()" + NL + "\t{" + NL + "\t\treturn ((";
  protected final String TEXT_146 = ")";
  protected final String TEXT_147 = ".INSTANCE).get";
  protected final String TEXT_148 = "();" + NL + "\t}" + NL;
  protected final String TEXT_149 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_150 = NL + "\t";
  protected final String TEXT_151 = "[] ";
  protected final String TEXT_152 = "();" + NL;
  protected final String TEXT_153 = NL + "\tpublic ";
  protected final String TEXT_154 = "[] ";
  protected final String TEXT_155 = "()" + NL + "\t{";
  protected final String TEXT_156 = NL + "\t\t";
  protected final String TEXT_157 = " list = (";
  protected final String TEXT_158 = ")";
  protected final String TEXT_159 = "();" + NL + "\t\tif (list.isEmpty()) return ";
  protected final String TEXT_160 = "_EEMPTY_ARRAY;";
  protected final String TEXT_161 = NL + "\t\tif (";
  protected final String TEXT_162 = " == null || ";
  protected final String TEXT_163 = ".isEmpty()) return ";
  protected final String TEXT_164 = "_EEMPTY_ARRAY;" + NL + "\t\t";
  protected final String TEXT_165 = " list = (";
  protected final String TEXT_166 = ")";
  protected final String TEXT_167 = ";";
  protected final String TEXT_168 = NL + "\t\tlist.shrink();" + NL + "\t\treturn (";
  protected final String TEXT_169 = "[])list.data();" + NL + "\t}" + NL;
  protected final String TEXT_170 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_171 = NL + "\t";
  protected final String TEXT_172 = " get";
  protected final String TEXT_173 = "(int index);";
  protected final String TEXT_174 = NL + "\tpublic ";
  protected final String TEXT_175 = " get";
  protected final String TEXT_176 = "(int index)" + NL + "\t{" + NL + "\t\treturn (";
  protected final String TEXT_177 = ")";
  protected final String TEXT_178 = "().get(index);" + NL + "\t}";
  protected final String TEXT_179 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_180 = NL + "\tint get";
  protected final String TEXT_181 = "Length();" + NL;
  protected final String TEXT_182 = NL + "\tpublic int get";
  protected final String TEXT_183 = "Length()" + NL + "\t{";
  protected final String TEXT_184 = NL + "\t\treturn ";
  protected final String TEXT_185 = "().size();";
  protected final String TEXT_186 = NL + "\t\treturn ";
  protected final String TEXT_187 = " == null ? 0 : ";
  protected final String TEXT_188 = ".size();";
  protected final String TEXT_189 = NL + "\t}" + NL;
  protected final String TEXT_190 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_191 = NL + "\tvoid set";
  protected final String TEXT_192 = "(";
  protected final String TEXT_193 = "[] new";
  protected final String TEXT_194 = ");" + NL;
  protected final String TEXT_195 = NL + "\tpublic void set";
  protected final String TEXT_196 = "(";
  protected final String TEXT_197 = "[] new";
  protected final String TEXT_198 = ")" + NL + "\t{" + NL + "\t\t((";
  protected final String TEXT_199 = ")";
  protected final String TEXT_200 = "()).setData(new";
  protected final String TEXT_201 = ".length, new";
  protected final String TEXT_202 = ");" + NL + "\t}" + NL;
  protected final String TEXT_203 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_204 = NL + "\tvoid set";
  protected final String TEXT_205 = "(int index, ";
  protected final String TEXT_206 = " element);" + NL;
  protected final String TEXT_207 = NL + "\tpublic void set";
  protected final String TEXT_208 = "(int index, ";
  protected final String TEXT_209 = " element)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_210 = "().set(index, element);" + NL + "\t}" + NL;
  protected final String TEXT_211 = NL + "\t/**" + NL + "\t * Returns the value of the '<em><b>";
  protected final String TEXT_212 = "</b></em>' ";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = NL + "\t * The key is of type ";
  protected final String TEXT_215 = "list of {@link ";
  protected final String TEXT_216 = "}";
  protected final String TEXT_217 = "{@link ";
  protected final String TEXT_218 = "}";
  protected final String TEXT_219 = "," + NL + "\t * and the value is of type ";
  protected final String TEXT_220 = "list of {@link ";
  protected final String TEXT_221 = "}";
  protected final String TEXT_222 = "{@link ";
  protected final String TEXT_223 = "}";
  protected final String TEXT_224 = ",";
  protected final String TEXT_225 = NL + "\t * The list contents are of type {@link ";
  protected final String TEXT_226 = "}.";
  protected final String TEXT_227 = NL + "\t * The default value is <code>";
  protected final String TEXT_228 = "</code>.";
  protected final String TEXT_229 = NL + "\t * The literals are from the enumeration {@link ";
  protected final String TEXT_230 = "}.";
  protected final String TEXT_231 = NL + "\t * It is bidirectional and its opposite is '{@link ";
  protected final String TEXT_232 = "#";
  protected final String TEXT_233 = " <em>";
  protected final String TEXT_234 = "</em>}'.";
  protected final String TEXT_235 = NL + "\t * <!-- begin-user-doc -->";
  protected final String TEXT_236 = NL + "\t * <p>" + NL + "\t * If the meaning of the '<em>";
  protected final String TEXT_237 = "</em>' ";
  protected final String TEXT_238 = " isn't clear," + NL + "\t * there really should be more of a description here..." + NL + "\t * </p>";
  protected final String TEXT_239 = NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_240 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_241 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_242 = NL + "\t * @return the value of the '<em>";
  protected final String TEXT_243 = "</em>' ";
  protected final String TEXT_244 = ".";
  protected final String TEXT_245 = NL + "\t * @see ";
  protected final String TEXT_246 = NL + "\t * @see #isSet";
  protected final String TEXT_247 = "()";
  protected final String TEXT_248 = NL + "\t * @see #unset";
  protected final String TEXT_249 = "()";
  protected final String TEXT_250 = NL + "\t * @see #set";
  protected final String TEXT_251 = "(";
  protected final String TEXT_252 = ")";
  protected final String TEXT_253 = NL + "\t * @see ";
  protected final String TEXT_254 = "#get";
  protected final String TEXT_255 = "()";
  protected final String TEXT_256 = NL + "\t * @see ";
  protected final String TEXT_257 = "#";
  protected final String TEXT_258 = NL + "\t * @model ";
  protected final String TEXT_259 = NL + "\t *        ";
  protected final String TEXT_260 = NL + "\t * @model";
  protected final String TEXT_261 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_262 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_263 = NL + "\t";
  protected final String TEXT_264 = " ";
  protected final String TEXT_265 = "();" + NL;
  protected final String TEXT_266 = NL + "\tpublic ";
  protected final String TEXT_267 = " ";
  protected final String TEXT_268 = "()" + NL + "\t{";
  protected final String TEXT_269 = NL + "\t\treturn ";
  protected final String TEXT_270 = "(";
  protected final String TEXT_271 = "(";
  protected final String TEXT_272 = ")get(";
  protected final String TEXT_273 = ", true)";
  protected final String TEXT_274 = ").";
  protected final String TEXT_275 = "()";
  protected final String TEXT_276 = ";";
  protected final String TEXT_277 = NL + "\t\t";
  protected final String TEXT_278 = " ";
  protected final String TEXT_279 = " = (";
  protected final String TEXT_280 = ")eVirtualGet(";
  protected final String TEXT_281 = ");";
  protected final String TEXT_282 = NL + "\t\tif (";
  protected final String TEXT_283 = " == null)" + NL + "\t\t{";
  protected final String TEXT_284 = NL + "\t\t\teVirtualSet(";
  protected final String TEXT_285 = ", ";
  protected final String TEXT_286 = " = new ";
  protected final String TEXT_287 = ");";
  protected final String TEXT_288 = NL + "\t\t  ";
  protected final String TEXT_289 = " = createSequence(INTERNAL_";
  protected final String TEXT_290 = ");";
  protected final String TEXT_291 = NL + "\t\t  ";
  protected final String TEXT_292 = " = createPropertyList(ListKind.CONTAINMENT, ";
  protected final String TEXT_293 = ".class, ";
  protected final String TEXT_294 = ");";
  protected final String TEXT_295 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_296 = ";";
  protected final String TEXT_297 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_298 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_299 = ")eContainer();";
  protected final String TEXT_300 = NL + "\t\t";
  protected final String TEXT_301 = " ";
  protected final String TEXT_302 = " = (";
  protected final String TEXT_303 = ")eVirtualGet(";
  protected final String TEXT_304 = ", ";
  protected final String TEXT_305 = "_DEFAULT_";
  protected final String TEXT_306 = ");";
  protected final String TEXT_307 = NL + "\t\tif (";
  protected final String TEXT_308 = " != null && isProxy(";
  protected final String TEXT_309 = "))" + NL + "\t\t{" + NL + "\t\t\tObject old";
  protected final String TEXT_310 = " = ";
  protected final String TEXT_311 = ";" + NL + "\t\t\t";
  protected final String TEXT_312 = " = ";
  protected final String TEXT_313 = "resolveProxy(old";
  protected final String TEXT_314 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_315 = " != old";
  protected final String TEXT_316 = ")" + NL + "\t\t\t{";
  protected final String TEXT_317 = NL + "\t\t\t\t";
  protected final String TEXT_318 = " new";
  protected final String TEXT_319 = " = (";
  protected final String TEXT_320 = ")";
  protected final String TEXT_321 = ";";
  protected final String TEXT_322 = NL + "\t\t\t\tChangeContext changeContext = old";
  protected final String TEXT_323 = ".inverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_324 = ", null, null);";
  protected final String TEXT_325 = NL + "\t\t\t\t";
  protected final String TEXT_326 = " changeContext =  old";
  protected final String TEXT_327 = ".inverseRemove(this, ";
  protected final String TEXT_328 = ", ";
  protected final String TEXT_329 = ".class, null);";
  protected final String TEXT_330 = NL + "\t\t\t\tif (new";
  protected final String TEXT_331 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
  protected final String TEXT_332 = NL + "\t\t\t\t\tchangeContext = new";
  protected final String TEXT_333 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_334 = ", null, changeContext);";
  protected final String TEXT_335 = NL + "\t\t\t\t\tchangeContext =  new";
  protected final String TEXT_336 = ".eInverseAdd(this, ";
  protected final String TEXT_337 = ", ";
  protected final String TEXT_338 = ".class, changeContext);";
  protected final String TEXT_339 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (changeContext != null) dispatch(changeContext);";
  protected final String TEXT_340 = NL + "\t\t\t\teVirtualSet(";
  protected final String TEXT_341 = ", ";
  protected final String TEXT_342 = ");";
  protected final String TEXT_343 = NL + "\t\t\t\tif (isNotifying())" + NL + "\t\t\t\t\tnotify(ChangeKind.RESOLVE, ";
  protected final String TEXT_344 = ", old";
  protected final String TEXT_345 = ", ";
  protected final String TEXT_346 = ");";
  protected final String TEXT_347 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_348 = NL + "\t\treturn (";
  protected final String TEXT_349 = ")eVirtualGet(";
  protected final String TEXT_350 = ", ";
  protected final String TEXT_351 = "_DEFAULT_";
  protected final String TEXT_352 = ");";
  protected final String TEXT_353 = NL + "\t\treturn (";
  protected final String TEXT_354 = " & ";
  protected final String TEXT_355 = "_EFLAG) != 0;";
  protected final String TEXT_356 = NL + "\t\treturn ";
  protected final String TEXT_357 = ";";
  protected final String TEXT_358 = NL + "\t\t";
  protected final String TEXT_359 = " ";
  protected final String TEXT_360 = " = basicGet";
  protected final String TEXT_361 = "();" + NL + "\t\treturn ";
  protected final String TEXT_362 = " != null && ";
  protected final String TEXT_363 = ".isProxy() ? ";
  protected final String TEXT_364 = "eResolveProxy((";
  protected final String TEXT_365 = ")";
  protected final String TEXT_366 = ") : ";
  protected final String TEXT_367 = ";";
  protected final String TEXT_368 = NL + "\t\treturn create";
  protected final String TEXT_369 = "(get";
  protected final String TEXT_370 = "(), getType(), ";
  protected final String TEXT_371 = ");";
  protected final String TEXT_372 = NL + "\t\treturn (";
  protected final String TEXT_373 = ")((";
  protected final String TEXT_374 = ")get";
  protected final String TEXT_375 = "()).list(";
  protected final String TEXT_376 = ");";
  protected final String TEXT_377 = NL + "          return get";
  protected final String TEXT_378 = "(get";
  protected final String TEXT_379 = "(), getType(), ";
  protected final String TEXT_380 = ");" + NL;
  protected final String TEXT_381 = NL + "\t\treturn ((";
  protected final String TEXT_382 = ")get";
  protected final String TEXT_383 = "()).list(";
  protected final String TEXT_384 = ");";
  protected final String TEXT_385 = NL + "\t\treturn ";
  protected final String TEXT_386 = "(";
  protected final String TEXT_387 = "(";
  protected final String TEXT_388 = ")get(get";
  protected final String TEXT_389 = "(), getType(), INTERNAL_";
  protected final String TEXT_390 = ")";
  protected final String TEXT_391 = ").";
  protected final String TEXT_392 = "()";
  protected final String TEXT_393 = ";";
  protected final String TEXT_394 = NL + "\t\treturn ";
  protected final String TEXT_395 = "(";
  protected final String TEXT_396 = "(";
  protected final String TEXT_397 = ")get(get";
  protected final String TEXT_398 = "(), getType(), INTERNAL_";
  protected final String TEXT_399 = ");";
  protected final String TEXT_400 = ").";
  protected final String TEXT_401 = "()";
  protected final String TEXT_402 = ";";
  protected final String TEXT_403 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_404 = "' ";
  protected final String TEXT_405 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_406 = NL + "\t}";
  protected final String TEXT_407 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_408 = " basicGet";
  protected final String TEXT_409 = "()" + NL + "\t{";
  protected final String TEXT_410 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_411 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_412 = ")eInternalContainer();";
  protected final String TEXT_413 = NL + "\t\treturn (";
  protected final String TEXT_414 = ")eVirtualGet(";
  protected final String TEXT_415 = ");";
  protected final String TEXT_416 = NL + "\t\treturn ";
  protected final String TEXT_417 = ";";
  protected final String TEXT_418 = NL + "\t\treturn (";
  protected final String TEXT_419 = ")get(get";
  protected final String TEXT_420 = "(), getType(), ";
  protected final String TEXT_421 = ");";
  protected final String TEXT_422 = NL + "\t\treturn (";
  protected final String TEXT_423 = ")get";
  protected final String TEXT_424 = "().get(";
  protected final String TEXT_425 = ", false);";
  protected final String TEXT_426 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_427 = "' ";
  protected final String TEXT_428 = NL + "\t\t// -> do not perform proxy resolution" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_429 = NL + "\t}" + NL;
  protected final String TEXT_430 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicSet";
  protected final String TEXT_431 = "(";
  protected final String TEXT_432 = " new";
  protected final String TEXT_433 = ", ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_434 = NL + "\t\tObject old";
  protected final String TEXT_435 = " = eVirtualSet(";
  protected final String TEXT_436 = ", new";
  protected final String TEXT_437 = ");";
  protected final String TEXT_438 = NL + "\t\t";
  protected final String TEXT_439 = " old";
  protected final String TEXT_440 = " = ";
  protected final String TEXT_441 = ";" + NL + "\t\t";
  protected final String TEXT_442 = " = new";
  protected final String TEXT_443 = ";";
  protected final String TEXT_444 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_445 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_446 = NL + "\t\tboolean old";
  protected final String TEXT_447 = "_set_ = (";
  protected final String TEXT_448 = " & ";
  protected final String TEXT_449 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_450 = " |= ";
  protected final String TEXT_451 = "_ESETFLAG;";
  protected final String TEXT_452 = NL + "\t\tboolean old";
  protected final String TEXT_453 = "_set_ = ";
  protected final String TEXT_454 = "_set_;" + NL + "\t\t";
  protected final String TEXT_455 = "_set_ = true;";
  protected final String TEXT_456 = NL + "\t\tif (isNotifying())" + NL + "\t\t{";
  protected final String TEXT_457 = NL + "\t\t\taddNotification(this, ChangeKind.SET, ";
  protected final String TEXT_458 = ", ";
  protected final String TEXT_459 = "isSetChange ? null : old";
  protected final String TEXT_460 = "old";
  protected final String TEXT_461 = ", new";
  protected final String TEXT_462 = ", ";
  protected final String TEXT_463 = "isSetChange";
  protected final String TEXT_464 = "!old";
  protected final String TEXT_465 = "_set_";
  protected final String TEXT_466 = ", changeContext);";
  protected final String TEXT_467 = NL + "\t\t\taddNotification(this, ChangeKind.SET, ";
  protected final String TEXT_468 = ", ";
  protected final String TEXT_469 = "old";
  protected final String TEXT_470 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_471 = "old";
  protected final String TEXT_472 = ", new";
  protected final String TEXT_473 = ", changeContext);";
  protected final String TEXT_474 = NL + "\t\t}";
  protected final String TEXT_475 = NL + "\t\treturn changeContext;";
  protected final String TEXT_476 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_477 = "(), getType(), ";
  protected final String TEXT_478 = ", new";
  protected final String TEXT_479 = ", changeContext);";
  protected final String TEXT_480 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_481 = "(), getType(), ";
  protected final String TEXT_482 = ", new";
  protected final String TEXT_483 = ", changeContext);";
  protected final String TEXT_484 = NL + "\t\t// TODO: implement this method to set the contained '";
  protected final String TEXT_485 = "' ";
  protected final String TEXT_486 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_487 = NL + "\t}" + NL;
  protected final String TEXT_488 = NL + "\t/**" + NL + "\t * Sets the value of the '{@link ";
  protected final String TEXT_489 = "#";
  protected final String TEXT_490 = " <em>";
  protected final String TEXT_491 = "</em>}' ";
  protected final String TEXT_492 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param value the new value of the '<em>";
  protected final String TEXT_493 = "</em>' ";
  protected final String TEXT_494 = ".";
  protected final String TEXT_495 = NL + "\t * @see ";
  protected final String TEXT_496 = NL + "\t * @see #isSet";
  protected final String TEXT_497 = "()";
  protected final String TEXT_498 = NL + "\t * @see #unset";
  protected final String TEXT_499 = "()";
  protected final String TEXT_500 = NL + "\t * @see #";
  protected final String TEXT_501 = "()" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_502 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_503 = NL + "\tvoid set";
  protected final String TEXT_504 = "(";
  protected final String TEXT_505 = " value);" + NL;
  protected final String TEXT_506 = NL + "\tpublic void set";
  protected final String TEXT_507 = "(";
  protected final String TEXT_508 = " new";
  protected final String TEXT_509 = ")" + NL + "\t{";
  protected final String TEXT_510 = NL + "\t\t_set_(";
  protected final String TEXT_511 = ", ";
  protected final String TEXT_512 = "new ";
  protected final String TEXT_513 = "(";
  protected final String TEXT_514 = "new";
  protected final String TEXT_515 = ")";
  protected final String TEXT_516 = ");";
  protected final String TEXT_517 = NL + "\t\tif (new";
  protected final String TEXT_518 = " != eInternalContainer() || (eContainerFeatureID != ";
  protected final String TEXT_519 = " && new";
  protected final String TEXT_520 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_521 = ".isAncestor(this, ";
  protected final String TEXT_522 = "new";
  protected final String TEXT_523 = "))" + NL + "\t\t\t\tthrow new ";
  protected final String TEXT_524 = "(\"Recursive containment not allowed for \" + toString());";
  protected final String TEXT_525 = NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_526 = " != null)" + NL + "\t\t\t\tchangeContext = ((";
  protected final String TEXT_527 = ")new";
  protected final String TEXT_528 = ").eInverseAdd(this, ";
  protected final String TEXT_529 = ", ";
  protected final String TEXT_530 = ".class, changeContext);" + NL + "\t\t\tchangeContext = eBasicSetContainer((";
  protected final String TEXT_531 = ")new";
  protected final String TEXT_532 = ", ";
  protected final String TEXT_533 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_534 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_535 = ", new";
  protected final String TEXT_536 = ", new";
  protected final String TEXT_537 = ");";
  protected final String TEXT_538 = NL + "\t\t";
  protected final String TEXT_539 = " ";
  protected final String TEXT_540 = " = (";
  protected final String TEXT_541 = ")eVirtualGet(";
  protected final String TEXT_542 = ");";
  protected final String TEXT_543 = NL + "\t\tif (new";
  protected final String TEXT_544 = " != ";
  protected final String TEXT_545 = ")" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (";
  protected final String TEXT_546 = " != null)";
  protected final String TEXT_547 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_548 = ", this, OPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_549 = ", null, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_550 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_551 = ", this, OPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_552 = ", null, changeContext);";
  protected final String TEXT_553 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_554 = ", this, ";
  protected final String TEXT_555 = ", ";
  protected final String TEXT_556 = ".class, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_557 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_558 = ", this, ";
  protected final String TEXT_559 = ", ";
  protected final String TEXT_560 = ".class, changeContext);";
  protected final String TEXT_561 = NL + "\t\t\tchangeContext = basicSet";
  protected final String TEXT_562 = "(";
  protected final String TEXT_563 = "new";
  protected final String TEXT_564 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_565 = NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_566 = NL + "\t\t\tboolean old";
  protected final String TEXT_567 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_568 = ");";
  protected final String TEXT_569 = NL + "\t\t\tboolean old";
  protected final String TEXT_570 = "_set_ = (";
  protected final String TEXT_571 = " & ";
  protected final String TEXT_572 = "_ESETFLAG) != 0;";
  protected final String TEXT_573 = NL + "\t\t\t";
  protected final String TEXT_574 = " |= ";
  protected final String TEXT_575 = "_ESETFLAG;";
  protected final String TEXT_576 = NL + "\t\t\tboolean old";
  protected final String TEXT_577 = "_set_ = ";
  protected final String TEXT_578 = "_set_;";
  protected final String TEXT_579 = NL + "\t\t\t";
  protected final String TEXT_580 = "_set_ = true;";
  protected final String TEXT_581 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_582 = ", new";
  protected final String TEXT_583 = ", new";
  protected final String TEXT_584 = ", !old";
  protected final String TEXT_585 = "_set_);";
  protected final String TEXT_586 = NL + "    \t}";
  protected final String TEXT_587 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_588 = ", new";
  protected final String TEXT_589 = ", new";
  protected final String TEXT_590 = ");";
  protected final String TEXT_591 = NL + "\t\t";
  protected final String TEXT_592 = " old";
  protected final String TEXT_593 = " = (";
  protected final String TEXT_594 = " & ";
  protected final String TEXT_595 = "_EFLAG) != 0;";
  protected final String TEXT_596 = NL + "\t\tif (new";
  protected final String TEXT_597 = ") ";
  protected final String TEXT_598 = " |= ";
  protected final String TEXT_599 = "_EFLAG; else ";
  protected final String TEXT_600 = " &= ~";
  protected final String TEXT_601 = "_EFLAG;";
  protected final String TEXT_602 = NL + "\t\t";
  protected final String TEXT_603 = " old";
  protected final String TEXT_604 = " = ";
  protected final String TEXT_605 = ";";
  protected final String TEXT_606 = NL + "\t\t";
  protected final String TEXT_607 = " ";
  protected final String TEXT_608 = " = new";
  protected final String TEXT_609 = " == null ? ";
  protected final String TEXT_610 = "_DEFAULT_ : new";
  protected final String TEXT_611 = ";";
  protected final String TEXT_612 = NL + "\t\t";
  protected final String TEXT_613 = " = new";
  protected final String TEXT_614 = " == null ? ";
  protected final String TEXT_615 = "_DEFAULT_ : new";
  protected final String TEXT_616 = ";";
  protected final String TEXT_617 = NL + "\t\t";
  protected final String TEXT_618 = " ";
  protected final String TEXT_619 = " = ";
  protected final String TEXT_620 = "new";
  protected final String TEXT_621 = ";";
  protected final String TEXT_622 = NL + "\t\t";
  protected final String TEXT_623 = " = ";
  protected final String TEXT_624 = "new";
  protected final String TEXT_625 = ";";
  protected final String TEXT_626 = NL + "\t\tObject old";
  protected final String TEXT_627 = " = eVirtualSet(";
  protected final String TEXT_628 = ", ";
  protected final String TEXT_629 = ");";
  protected final String TEXT_630 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_631 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_632 = NL + "\t\tboolean old";
  protected final String TEXT_633 = "_set_ = (";
  protected final String TEXT_634 = " & ";
  protected final String TEXT_635 = "_ESETFLAG) != 0;";
  protected final String TEXT_636 = NL + "\t\t";
  protected final String TEXT_637 = " |= ";
  protected final String TEXT_638 = "_ESETFLAG;";
  protected final String TEXT_639 = NL + "\t\tboolean old";
  protected final String TEXT_640 = "_set_ = ";
  protected final String TEXT_641 = "_set_;";
  protected final String TEXT_642 = NL + "\t\t";
  protected final String TEXT_643 = "_set_ = true;";
  protected final String TEXT_644 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_645 = ", ";
  protected final String TEXT_646 = "isSetChange ? ";
  protected final String TEXT_647 = "null";
  protected final String TEXT_648 = "_DEFAULT_";
  protected final String TEXT_649 = " : old";
  protected final String TEXT_650 = "old";
  protected final String TEXT_651 = ", ";
  protected final String TEXT_652 = "new";
  protected final String TEXT_653 = ", ";
  protected final String TEXT_654 = "isSetChange";
  protected final String TEXT_655 = "!old";
  protected final String TEXT_656 = "_set_";
  protected final String TEXT_657 = ");";
  protected final String TEXT_658 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_659 = ", ";
  protected final String TEXT_660 = "old";
  protected final String TEXT_661 = " == EVIRTUAL_NO_VALUE ? ";
  protected final String TEXT_662 = "null";
  protected final String TEXT_663 = "_DEFAULT_";
  protected final String TEXT_664 = " : old";
  protected final String TEXT_665 = "old";
  protected final String TEXT_666 = ", ";
  protected final String TEXT_667 = "new";
  protected final String TEXT_668 = ");";
  protected final String TEXT_669 = NL + "\t\tset(get";
  protected final String TEXT_670 = "(), getType(), INTERNAL_";
  protected final String TEXT_671 = ", ";
  protected final String TEXT_672 = " new ";
  protected final String TEXT_673 = "(";
  protected final String TEXT_674 = "new";
  protected final String TEXT_675 = ")";
  protected final String TEXT_676 = ");";
  protected final String TEXT_677 = NL + "\t\t((";
  protected final String TEXT_678 = ".Internal)get";
  protected final String TEXT_679 = "()).set(";
  protected final String TEXT_680 = ", ";
  protected final String TEXT_681 = "new ";
  protected final String TEXT_682 = "(";
  protected final String TEXT_683 = "new";
  protected final String TEXT_684 = ")";
  protected final String TEXT_685 = ");";
  protected final String TEXT_686 = NL + "\t\t// TODO: implement this method to set the '";
  protected final String TEXT_687 = "' ";
  protected final String TEXT_688 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_689 = NL + "\t}" + NL;
  protected final String TEXT_690 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicUnset";
  protected final String TEXT_691 = "(ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_692 = NL + "\t\tObject old";
  protected final String TEXT_693 = " = eVirtualUnset(";
  protected final String TEXT_694 = ");";
  protected final String TEXT_695 = NL + "\t\t";
  protected final String TEXT_696 = " old";
  protected final String TEXT_697 = " = ";
  protected final String TEXT_698 = ";" + NL + "\t\t";
  protected final String TEXT_699 = " = null;";
  protected final String TEXT_700 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_701 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_702 = NL + "\t\tboolean old";
  protected final String TEXT_703 = "_set_ = (";
  protected final String TEXT_704 = " & ";
  protected final String TEXT_705 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_706 = " &= ~";
  protected final String TEXT_707 = "_ESETFLAG;";
  protected final String TEXT_708 = NL + "\t\tboolean old";
  protected final String TEXT_709 = "_set_ = ";
  protected final String TEXT_710 = "_set_;" + NL + "\t\t";
  protected final String TEXT_711 = "_set_ = false;";
  protected final String TEXT_712 = NL + "\t\tif (isNotifying())" + NL + "\t\t{";
  protected final String TEXT_713 = NL + "\t\t\taddNotification(this, ChangeKind.UNSET, ";
  protected final String TEXT_714 = ", ";
  protected final String TEXT_715 = "isSetChange ? null : old";
  protected final String TEXT_716 = "old";
  protected final String TEXT_717 = ", null, ";
  protected final String TEXT_718 = "isSetChange";
  protected final String TEXT_719 = "!old";
  protected final String TEXT_720 = "_set_";
  protected final String TEXT_721 = ", changeContext);";
  protected final String TEXT_722 = NL + "\t\t\taddNotification(this, ChangeKind.UNSET, ";
  protected final String TEXT_723 = ", ";
  protected final String TEXT_724 = "old";
  protected final String TEXT_725 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_726 = "old";
  protected final String TEXT_727 = ", null, changeContext);";
  protected final String TEXT_728 = NL + "\t\t}" + NL + "\t\treturn changeContext;";
  protected final String TEXT_729 = NL + "\t\t// TODO: implement this method to unset the contained '";
  protected final String TEXT_730 = "' ";
  protected final String TEXT_731 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_732 = NL + "\t}" + NL;
  protected final String TEXT_733 = NL + "\t/**" + NL + "\t * Unsets the value of the '{@link ";
  protected final String TEXT_734 = "#";
  protected final String TEXT_735 = " <em>";
  protected final String TEXT_736 = "</em>}' ";
  protected final String TEXT_737 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_738 = NL + "\t * @see #isSet";
  protected final String TEXT_739 = "()";
  protected final String TEXT_740 = NL + "\t * @see #";
  protected final String TEXT_741 = "()";
  protected final String TEXT_742 = NL + "\t * @see #set";
  protected final String TEXT_743 = "(";
  protected final String TEXT_744 = ")";
  protected final String TEXT_745 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_746 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_747 = NL + "\tvoid unset";
  protected final String TEXT_748 = "();" + NL;
  protected final String TEXT_749 = NL + "\tpublic void unset";
  protected final String TEXT_750 = "()" + NL + "\t{";
  protected final String TEXT_751 = NL + "\t\tunset(";
  protected final String TEXT_752 = ");";
  protected final String TEXT_753 = NL + "\t\t((";
  protected final String TEXT_754 = ".Unsettable)get";
  protected final String TEXT_755 = "()).unset();";
  protected final String TEXT_756 = NL + "\t\t";
  protected final String TEXT_757 = " ";
  protected final String TEXT_758 = " = (";
  protected final String TEXT_759 = ")eVirtualGet(";
  protected final String TEXT_760 = ");";
  protected final String TEXT_761 = NL + "\t\tif (";
  protected final String TEXT_762 = " != null)" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;";
  protected final String TEXT_763 = NL + "\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_764 = ", this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_765 = ", null, changeContext);";
  protected final String TEXT_766 = NL + "\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_767 = ", this, ";
  protected final String TEXT_768 = ", ";
  protected final String TEXT_769 = ".class, changeContext);";
  protected final String TEXT_770 = NL + "\t\t\tchangeContext = basicUnset";
  protected final String TEXT_771 = "(changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}" + NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_772 = NL + "\t\t\tboolean old";
  protected final String TEXT_773 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_774 = ");";
  protected final String TEXT_775 = NL + "\t\t\tboolean old";
  protected final String TEXT_776 = "_set_ = (";
  protected final String TEXT_777 = " & ";
  protected final String TEXT_778 = "_ESETFLAG) != 0;";
  protected final String TEXT_779 = NL + "\t\t\t";
  protected final String TEXT_780 = " &= ~";
  protected final String TEXT_781 = "_ESETFLAG;";
  protected final String TEXT_782 = NL + "\t\t\tboolean old";
  protected final String TEXT_783 = "_set_ = ";
  protected final String TEXT_784 = "_set_;";
  protected final String TEXT_785 = NL + "\t\t\t";
  protected final String TEXT_786 = "_set_ = false;";
  protected final String TEXT_787 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_788 = ", null, null, old";
  protected final String TEXT_789 = "_set_);";
  protected final String TEXT_790 = NL + "    \t}";
  protected final String TEXT_791 = NL + "\t\t";
  protected final String TEXT_792 = " old";
  protected final String TEXT_793 = " = (";
  protected final String TEXT_794 = " & ";
  protected final String TEXT_795 = "_EFLAG) != 0;";
  protected final String TEXT_796 = NL + "\t\tObject old";
  protected final String TEXT_797 = " = eVirtualUnset(";
  protected final String TEXT_798 = ");";
  protected final String TEXT_799 = NL + "\t\t";
  protected final String TEXT_800 = " old";
  protected final String TEXT_801 = " = ";
  protected final String TEXT_802 = ";";
  protected final String TEXT_803 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_804 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_805 = NL + "\t\tboolean old";
  protected final String TEXT_806 = "_set_ = (";
  protected final String TEXT_807 = " & ";
  protected final String TEXT_808 = "_ESETFLAG) != 0;";
  protected final String TEXT_809 = NL + "\t\tboolean old";
  protected final String TEXT_810 = "_set_ = ";
  protected final String TEXT_811 = "_set_;";
  protected final String TEXT_812 = NL + "\t\t";
  protected final String TEXT_813 = " = null;";
  protected final String TEXT_814 = NL + "\t\t";
  protected final String TEXT_815 = " &= ~";
  protected final String TEXT_816 = "_ESETFLAG;";
  protected final String TEXT_817 = NL + "\t\t";
  protected final String TEXT_818 = "_set_ = false;";
  protected final String TEXT_819 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_820 = ", ";
  protected final String TEXT_821 = "isSetChange ? old";
  protected final String TEXT_822 = " : null";
  protected final String TEXT_823 = "old";
  protected final String TEXT_824 = ", null, ";
  protected final String TEXT_825 = "isSetChange";
  protected final String TEXT_826 = "old";
  protected final String TEXT_827 = "_set_";
  protected final String TEXT_828 = ");";
  protected final String TEXT_829 = NL + "\t\tif (";
  protected final String TEXT_830 = "_DEFAULT_) ";
  protected final String TEXT_831 = " |= ";
  protected final String TEXT_832 = "_EFLAG; else ";
  protected final String TEXT_833 = " &= ~";
  protected final String TEXT_834 = "_EFLAG;";
  protected final String TEXT_835 = NL + "\t\t";
  protected final String TEXT_836 = " = ";
  protected final String TEXT_837 = "_DEFAULT_;";
  protected final String TEXT_838 = NL + "\t\t";
  protected final String TEXT_839 = " &= ~";
  protected final String TEXT_840 = "_ESETFLAG;";
  protected final String TEXT_841 = NL + "\t\t";
  protected final String TEXT_842 = "_set_ = false;";
  protected final String TEXT_843 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_844 = ", ";
  protected final String TEXT_845 = "isSetChange ? old";
  protected final String TEXT_846 = " : ";
  protected final String TEXT_847 = "_DEFAULT_";
  protected final String TEXT_848 = "old";
  protected final String TEXT_849 = ", ";
  protected final String TEXT_850 = "_DEFAULT_, ";
  protected final String TEXT_851 = "isSetChange";
  protected final String TEXT_852 = "old";
  protected final String TEXT_853 = "_set_";
  protected final String TEXT_854 = ");";
  protected final String TEXT_855 = NL + "        unset(get";
  protected final String TEXT_856 = "(), getType(), ";
  protected final String TEXT_857 = ");";
  protected final String TEXT_858 = NL + "        unset";
  protected final String TEXT_859 = "(get";
  protected final String TEXT_860 = "());";
  protected final String TEXT_861 = NL + "\t\t// TODO: implement this method to unset the '";
  protected final String TEXT_862 = "' ";
  protected final String TEXT_863 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_864 = NL + "\t}" + NL;
  protected final String TEXT_865 = NL + "\t/**" + NL + "\t * Returns whether the value of the '{@link ";
  protected final String TEXT_866 = "#";
  protected final String TEXT_867 = " <em>";
  protected final String TEXT_868 = "</em>}' ";
  protected final String TEXT_869 = " is set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return whether the value of the '<em>";
  protected final String TEXT_870 = "</em>' ";
  protected final String TEXT_871 = " is set.";
  protected final String TEXT_872 = NL + "\t * @see #unset";
  protected final String TEXT_873 = "()";
  protected final String TEXT_874 = NL + "\t * @see #";
  protected final String TEXT_875 = "()";
  protected final String TEXT_876 = NL + "\t * @see #set";
  protected final String TEXT_877 = "(";
  protected final String TEXT_878 = ")";
  protected final String TEXT_879 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_880 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_881 = NL + "\tboolean isSet";
  protected final String TEXT_882 = "();" + NL;
  protected final String TEXT_883 = NL + "\tpublic boolean isSet";
  protected final String TEXT_884 = "()" + NL + "\t{";
  protected final String TEXT_885 = NL + "\t\treturn isSet(";
  protected final String TEXT_886 = ");";
  protected final String TEXT_887 = NL + "\t\t";
  protected final String TEXT_888 = " ";
  protected final String TEXT_889 = " = (";
  protected final String TEXT_890 = ")eVirtualGet(";
  protected final String TEXT_891 = ");";
  protected final String TEXT_892 = NL + "\t\treturn ";
  protected final String TEXT_893 = " != null && ((";
  protected final String TEXT_894 = ".Unsettable)";
  protected final String TEXT_895 = ").isSet();";
  protected final String TEXT_896 = NL + "\t\treturn eVirtualIsSet(";
  protected final String TEXT_897 = ");";
  protected final String TEXT_898 = NL + "\t\treturn (";
  protected final String TEXT_899 = " & ";
  protected final String TEXT_900 = "_ESETFLAG) != 0;";
  protected final String TEXT_901 = NL + "\t\treturn ";
  protected final String TEXT_902 = "_set_;";
  protected final String TEXT_903 = NL + "        return isSet(get";
  protected final String TEXT_904 = "(), getType(), ";
  protected final String TEXT_905 = ");";
  protected final String TEXT_906 = NL + "\t\treturn !((";
  protected final String TEXT_907 = ".Internal)get";
  protected final String TEXT_908 = "()).isEmpty(";
  protected final String TEXT_909 = ");";
  protected final String TEXT_910 = NL + "\t\t// TODO: implement this method to return whether the '";
  protected final String TEXT_911 = "' ";
  protected final String TEXT_912 = " is set" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_913 = NL + "\t}" + NL;
  protected final String TEXT_914 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_915 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_916 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_917 = NL + "\t * @model ";
  protected final String TEXT_918 = NL + "\t *        ";
  protected final String TEXT_919 = NL + "\t * @model";
  protected final String TEXT_920 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_921 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_922 = NL + "\t";
  protected final String TEXT_923 = " ";
  protected final String TEXT_924 = "(";
  protected final String TEXT_925 = ")";
  protected final String TEXT_926 = ";" + NL;
  protected final String TEXT_927 = NL + "\tpublic ";
  protected final String TEXT_928 = " ";
  protected final String TEXT_929 = "(";
  protected final String TEXT_930 = ")";
  protected final String TEXT_931 = NL + "\t{";
  protected final String TEXT_932 = NL + "\t\t";
  protected final String TEXT_933 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_934 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_935 = ".add" + NL + "\t\t\t\t\t(new ";
  protected final String TEXT_936 = NL + "\t\t\t\t\t\t(";
  protected final String TEXT_937 = ".ERROR," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_938 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_939 = ".";
  protected final String TEXT_940 = "," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_941 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
  protected final String TEXT_942 = "\", ";
  protected final String TEXT_943 = ".getObjectLabel(this, ";
  protected final String TEXT_944 = ") }),";
  protected final String TEXT_945 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
  protected final String TEXT_946 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_947 = NL + "\t}" + NL;
  protected final String TEXT_948 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eInverseAdd(";
  protected final String TEXT_949 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_950 = NL + "\t\t\tcase ";
  protected final String TEXT_951 = ":";
  protected final String TEXT_952 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_953 = ")((";
  protected final String TEXT_954 = ".InternalMapView)";
  protected final String TEXT_955 = "()).eMap()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_956 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_957 = ")";
  protected final String TEXT_958 = "()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_959 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
  protected final String TEXT_960 = ", changeContext);";
  protected final String TEXT_961 = NL + "\t\t\t\t";
  protected final String TEXT_962 = " ";
  protected final String TEXT_963 = " = (";
  protected final String TEXT_964 = ")eVirtualGet(";
  protected final String TEXT_965 = ");";
  protected final String TEXT_966 = NL + "\t\t\t\tif (";
  protected final String TEXT_967 = " != null)";
  protected final String TEXT_968 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_969 = ")";
  protected final String TEXT_970 = ").inverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_971 = ", null, changeContext);";
  protected final String TEXT_972 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_973 = ")";
  protected final String TEXT_974 = ").inverseRemove(this, ";
  protected final String TEXT_975 = ", ";
  protected final String TEXT_976 = ".class, changeContext);";
  protected final String TEXT_977 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_978 = "((";
  protected final String TEXT_979 = ")otherEnd, changeContext);";
  protected final String TEXT_980 = NL + "\t\t}";
  protected final String TEXT_981 = NL + "\t\treturn super.eInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_982 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_983 = NL + "\t}" + NL;
  protected final String TEXT_984 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext inverseRemove(";
  protected final String TEXT_985 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_986 = NL + "\t\t\tcase ";
  protected final String TEXT_987 = ":";
  protected final String TEXT_988 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_989 = ")((";
  protected final String TEXT_990 = ".InternalMapView)";
  protected final String TEXT_991 = "()).eMap()).basicRemove(otherEnd, changeContext);";
  protected final String TEXT_992 = NL + "\t\t\t\treturn removeFrom";
  protected final String TEXT_993 = "(";
  protected final String TEXT_994 = "(), otherEnd, changeContext);";
  protected final String TEXT_995 = NL + "\t\t\t\treturn removeFromList(";
  protected final String TEXT_996 = "(), otherEnd, changeContext);";
  protected final String TEXT_997 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
  protected final String TEXT_998 = ", changeContext);";
  protected final String TEXT_999 = NL + "\t\t\t\treturn basicUnset";
  protected final String TEXT_1000 = "(changeContext);";
  protected final String TEXT_1001 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1002 = "(null, changeContext);";
  protected final String TEXT_1003 = NL + "\t\t}";
  protected final String TEXT_1004 = NL + "\t\treturn super.inverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_1005 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_1006 = NL + "\t}" + NL;
  protected final String TEXT_1007 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eBasicRemoveFromContainerFeature(ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID)" + NL + "\t\t{";
  protected final String TEXT_1008 = NL + "\t\t\tcase ";
  protected final String TEXT_1009 = ":" + NL + "\t\t\t\treturn eInternalContainer().inverseRemove(this, ";
  protected final String TEXT_1010 = ", ";
  protected final String TEXT_1011 = ".class, changeContext);";
  protected final String TEXT_1012 = NL + "\t\t}";
  protected final String TEXT_1013 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(changeContext);";
  protected final String TEXT_1014 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(changeContext);";
  protected final String TEXT_1015 = NL + "\t}" + NL;
  protected final String TEXT_1016 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object get(int propertyIndex, boolean resolve)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1017 = NL + "\t\t\tcase ";
  protected final String TEXT_1018 = ":";
  protected final String TEXT_1019 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1020 = "() ? Boolean.TRUE : Boolean.FALSE;";
  protected final String TEXT_1021 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_1022 = "(";
  protected final String TEXT_1023 = "());";
  protected final String TEXT_1024 = NL + "\t\t\t\tif (resolve) return ";
  protected final String TEXT_1025 = "();" + NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1026 = "();";
  protected final String TEXT_1027 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1028 = ".InternalMapView)";
  protected final String TEXT_1029 = "()).eMap();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1030 = "();";
  protected final String TEXT_1031 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1032 = "();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1033 = "().map();";
  protected final String TEXT_1034 = NL + "\t\t\t\t// XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view" + NL + "\t\t\t\t//if (coreType) " + NL + "\t\t\t\treturn ";
  protected final String TEXT_1035 = "();";
  protected final String TEXT_1036 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1037 = "();" + NL + "\t\t\t\treturn ((";
  protected final String TEXT_1038 = ".Internal)";
  protected final String TEXT_1039 = "()).getWrapper();";
  protected final String TEXT_1040 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1041 = "();";
  protected final String TEXT_1042 = NL + "\t\t}";
  protected final String TEXT_1043 = NL + "\t\treturn super.get(propertyIndex, resolve);";
  protected final String TEXT_1044 = NL + "\t\treturn eDynamicGet(propertyIndex, resolve, coreType);";
  protected final String TEXT_1045 = NL + "\t}" + NL;
  protected final String TEXT_1046 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void set(int propertyIndex, Object newValue)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1047 = NL + "\t\t\tcase ";
  protected final String TEXT_1048 = ":";
  protected final String TEXT_1049 = NL + "      \tset";
  protected final String TEXT_1050 = "(";
  protected final String TEXT_1051 = "(), newValue);";
  protected final String TEXT_1052 = NL + "\t\t\t\t((";
  protected final String TEXT_1053 = ".Internal)";
  protected final String TEXT_1054 = "()).set(newValue);";
  protected final String TEXT_1055 = NL + "\t\t\t\t((";
  protected final String TEXT_1056 = ".Setting)((";
  protected final String TEXT_1057 = ".InternalMapView)";
  protected final String TEXT_1058 = "()).eMap()).set(newValue);";
  protected final String TEXT_1059 = NL + "\t\t\t\t((";
  protected final String TEXT_1060 = ".Setting)";
  protected final String TEXT_1061 = "()).set(newValue);";
  protected final String TEXT_1062 = NL + "\t\t\t\t";
  protected final String TEXT_1063 = "().clear();" + NL + "\t\t\t\t";
  protected final String TEXT_1064 = "().addAll((";
  protected final String TEXT_1065 = ")newValue);";
  protected final String TEXT_1066 = NL + "\t\t\t\tset";
  protected final String TEXT_1067 = "(((";
  protected final String TEXT_1068 = ")newValue).";
  protected final String TEXT_1069 = "());";
  protected final String TEXT_1070 = NL + "\t\t\t\tset";
  protected final String TEXT_1071 = "((";
  protected final String TEXT_1072 = ")newValue);";
  protected final String TEXT_1073 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1074 = NL + "\t\t}";
  protected final String TEXT_1075 = NL + "\t\tsuper.set(propertyIndex, newValue);";
  protected final String TEXT_1076 = NL + "\t\teDynamicSet(propertyIndex, newValue);";
  protected final String TEXT_1077 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void unset(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1078 = NL + "\t\t\tcase ";
  protected final String TEXT_1079 = ":";
  protected final String TEXT_1080 = NL + "\t\t\t\tunset";
  protected final String TEXT_1081 = "(";
  protected final String TEXT_1082 = "());";
  protected final String TEXT_1083 = NL + "\t\t\t\t";
  protected final String TEXT_1084 = "().clear();";
  protected final String TEXT_1085 = NL + "\t\t\t\tunset";
  protected final String TEXT_1086 = "();";
  protected final String TEXT_1087 = NL + "\t\t\t\tset";
  protected final String TEXT_1088 = "((";
  protected final String TEXT_1089 = ")null);";
  protected final String TEXT_1090 = NL + "\t\t\t\tset";
  protected final String TEXT_1091 = "(";
  protected final String TEXT_1092 = "_DEFAULT_);";
  protected final String TEXT_1093 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1094 = NL + "\t\t}";
  protected final String TEXT_1095 = NL + "\t\tsuper.unset(propertyIndex);";
  protected final String TEXT_1096 = NL + "\t\teDynamicUnset(propertyIndex);";
  protected final String TEXT_1097 = NL + "\t}" + NL;
  protected final String TEXT_1098 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSet(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1099 = NL + "\t\t\tcase ";
  protected final String TEXT_1100 = ":";
  protected final String TEXT_1101 = NL + "\t\t\t\treturn !is";
  protected final String TEXT_1102 = "Empty(";
  protected final String TEXT_1103 = "());";
  protected final String TEXT_1104 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1105 = " != null && !is";
  protected final String TEXT_1106 = "Empty(";
  protected final String TEXT_1107 = "());";
  protected final String TEXT_1108 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1109 = " != null && !";
  protected final String TEXT_1110 = ".isEmpty();";
  protected final String TEXT_1111 = NL + "\t\t\t\t";
  protected final String TEXT_1112 = " ";
  protected final String TEXT_1113 = " = (";
  protected final String TEXT_1114 = ")eVirtualGet(";
  protected final String TEXT_1115 = ");" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1116 = " != null && !";
  protected final String TEXT_1117 = ".isEmpty();";
  protected final String TEXT_1118 = NL + "\t\t\t\treturn !";
  protected final String TEXT_1119 = "().isEmpty();";
  protected final String TEXT_1120 = NL + "\t\t\t\treturn isSet";
  protected final String TEXT_1121 = "();";
  protected final String TEXT_1122 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1123 = " != null;";
  protected final String TEXT_1124 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1125 = ") != null;";
  protected final String TEXT_1126 = NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1127 = "() != null;";
  protected final String TEXT_1128 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1129 = " != null;";
  protected final String TEXT_1130 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1131 = ") != null;";
  protected final String TEXT_1132 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1133 = "() != null;";
  protected final String TEXT_1134 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1135 = " & ";
  protected final String TEXT_1136 = "_EFLAG) != 0) != ";
  protected final String TEXT_1137 = "_DEFAULT_;";
  protected final String TEXT_1138 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1139 = " != ";
  protected final String TEXT_1140 = "_DEFAULT_;";
  protected final String TEXT_1141 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1142 = ", ";
  protected final String TEXT_1143 = "_DEFAULT_) != ";
  protected final String TEXT_1144 = "_DEFAULT_;";
  protected final String TEXT_1145 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1146 = "() != ";
  protected final String TEXT_1147 = "_DEFAULT_;";
  protected final String TEXT_1148 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1149 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1150 = " != null : !";
  protected final String TEXT_1151 = "_DEFAULT_.equals(";
  protected final String TEXT_1152 = ");";
  protected final String TEXT_1153 = NL + "\t\t\t\t";
  protected final String TEXT_1154 = " ";
  protected final String TEXT_1155 = " = (";
  protected final String TEXT_1156 = ")eVirtualGet(";
  protected final String TEXT_1157 = ", ";
  protected final String TEXT_1158 = "_DEFAULT_);" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1159 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1160 = " != null : !";
  protected final String TEXT_1161 = "_DEFAULT_.equals(";
  protected final String TEXT_1162 = ");";
  protected final String TEXT_1163 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1164 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1165 = "() != null : !";
  protected final String TEXT_1166 = "_DEFAULT_.equals(";
  protected final String TEXT_1167 = "());";
  protected final String TEXT_1168 = NL + "\t\t}";
  protected final String TEXT_1169 = NL + "\t\treturn super.isSet(propertyIndex);";
  protected final String TEXT_1170 = NL + "\t\treturn eDynamicIsSet(propertyIndex);";
  protected final String TEXT_1171 = NL + "\t}" + NL;
  protected final String TEXT_1172 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1173 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1174 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1175 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1176 = ": return ";
  protected final String TEXT_1177 = ";";
  protected final String TEXT_1178 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1179 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1180 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1181 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1182 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1183 = ": return ";
  protected final String TEXT_1184 = ";";
  protected final String TEXT_1185 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1186 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);" + NL + "\t}" + NL;
  protected final String TEXT_1187 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_1188 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualValues(Object[] newValues)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1189 = " = newValues;" + NL + "\t}" + NL;
  protected final String TEXT_1190 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1191 = NL + "\t\t\tcase ";
  protected final String TEXT_1192 = " :" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1193 = ";";
  protected final String TEXT_1194 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualIndexBits(int offset, int newIndexBits)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1195 = NL + "\t\t\tcase ";
  protected final String TEXT_1196 = " :" + NL + "\t\t\t\t";
  protected final String TEXT_1197 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_1198 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_1199 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String toString()" + NL + "\t{" + NL + "\t\tif (isProxy(this)) return super.toString();" + NL + "" + NL + "\t\tStringBuffer result = new StringBuffer(super.toString());";
  protected final String TEXT_1200 = NL + "\t\tresult.append(\" (";
  protected final String TEXT_1201 = ": \");";
  protected final String TEXT_1202 = NL + "\t\tresult.append(\", ";
  protected final String TEXT_1203 = ": \");";
  protected final String TEXT_1204 = NL + "\t\tif (eVirtualIsSet(";
  protected final String TEXT_1205 = ")) result.append(eVirtualGet(";
  protected final String TEXT_1206 = ")); else result.append(\"<unset>\");";
  protected final String TEXT_1207 = NL + "\t\tif (";
  protected final String TEXT_1208 = "(";
  protected final String TEXT_1209 = " & ";
  protected final String TEXT_1210 = "_ESETFLAG) != 0";
  protected final String TEXT_1211 = "_set_";
  protected final String TEXT_1212 = ") result.append((";
  protected final String TEXT_1213 = " & ";
  protected final String TEXT_1214 = "_EFLAG) != 0); else result.append(\"<unset>\");";
  protected final String TEXT_1215 = NL + "\t\tif (";
  protected final String TEXT_1216 = "(";
  protected final String TEXT_1217 = " & ";
  protected final String TEXT_1218 = "_ESETFLAG) != 0";
  protected final String TEXT_1219 = "_set_";
  protected final String TEXT_1220 = ") result.append(";
  protected final String TEXT_1221 = "); else result.append(\"<unset>\");";
  protected final String TEXT_1222 = NL + "\t\tresult.append(eVirtualGet(";
  protected final String TEXT_1223 = ", ";
  protected final String TEXT_1224 = "_DEFAULT_";
  protected final String TEXT_1225 = "));";
  protected final String TEXT_1226 = NL + "\t\tresult.append((";
  protected final String TEXT_1227 = " & ";
  protected final String TEXT_1228 = "_EFLAG) != 0);";
  protected final String TEXT_1229 = NL + "\t\tresult.append(";
  protected final String TEXT_1230 = ");";
  protected final String TEXT_1231 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}" + NL;
  protected final String TEXT_1232 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)" + NL + "\t\t{" + NL + "\t\t\tObject theKey = getKey();" + NL + "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL + "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic Object getKey()" + NL + "\t{" + NL + "  \t";
  protected final String TEXT_1233 = NL + "\t\treturn new ";
  protected final String TEXT_1234 = "(getTypedKey());" + NL + " \t";
  protected final String TEXT_1235 = NL + "\t\treturn getTypedKey();" + NL + "  \t";
  protected final String TEXT_1236 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(Object key)" + NL + "\t{";
  protected final String TEXT_1237 = NL + "\t\tgetTypedKey().addAll((";
  protected final String TEXT_1238 = ")key);";
  protected final String TEXT_1239 = NL + "\t\tsetTypedKey(((";
  protected final String TEXT_1240 = ")key).";
  protected final String TEXT_1241 = "());";
  protected final String TEXT_1242 = NL + "\t\tsetTypedKey((";
  protected final String TEXT_1243 = ")key);";
  protected final String TEXT_1244 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getValue()" + NL + "\t{" + NL + " \t";
  protected final String TEXT_1245 = NL + "\t\treturn new ";
  protected final String TEXT_1246 = "(getTypedValue());" + NL + " \t";
  protected final String TEXT_1247 = NL + "\t\treturn getTypedValue();" + NL + " \t";
  protected final String TEXT_1248 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object setValue(Object value)" + NL + "\t{" + NL + "\t\tObject oldValue = getValue();" + NL + "  \t";
  protected final String TEXT_1249 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll((";
  protected final String TEXT_1250 = ")value);" + NL + "  \t";
  protected final String TEXT_1251 = NL + "\t\tsetTypedValue(((";
  protected final String TEXT_1252 = ")value).";
  protected final String TEXT_1253 = "());" + NL + "  \t";
  protected final String TEXT_1254 = NL + "\t\tsetTypedValue((";
  protected final String TEXT_1255 = ")value);" + NL + "  \t";
  protected final String TEXT_1256 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1257 = " getEMap()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1258 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
  protected final String TEXT_1259 = ")container.get(eContainmentFeature());" + NL + "\t}";
  protected final String TEXT_1260 = NL + "} //";
  protected final String TEXT_1261 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

    GenClass genClass = (GenClass)((Object[])argument)[0]; GenPackage genPackage = genClass.getGenPackage(); GenModel genModel=genPackage.getGenModel();
    boolean isInterface = Boolean.TRUE.equals(((Object[])argument)[1]); boolean isImplementation = Boolean.TRUE.equals(((Object[])argument)[2]);
    boolean isDebug = false;
    String publicStaticFinalFlag = isImplementation ? "public static final " : "";
    /*
     * Output preamble and javadoc header
     */
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_4);
    if (isInterface) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genPackage.getInterfacePackageName());
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genPackage.getClassPackageName());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    genModel.markImportLocation(stringBuffer, genPackage);
    stringBuffer.append(TEXT_10);
    if (isDebug) { // EYECATCHER 1 
    stringBuffer.append(TEXT_11);
    }
    if (isInterface) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_13);
    if (genClass.hasDocumentation()) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genClass.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if (!genClass.getGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_17);
    for (Iterator i=genClass.getGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (isDebug) { // EYECATCHER 2
    stringBuffer.append(TEXT_18);
     } 
    if (!genFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_22);
    }
    }
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_27);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_30);
    }}
    if (genClass.needsRootExtendsInterfaceExtendsTag()) { // does it need an @extends tag 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
    }
    stringBuffer.append(TEXT_32);
    } else {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_34);
    if (!genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_35);
    for (Iterator i=genClass.getImplementedGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genClass.getQualifiedClassName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_42);
    if (genClass.isAbstract()) {
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(genClass.getClassExtends());
    stringBuffer.append(genClass.getClassImplements());
    } else {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genClass.getInterfaceName());
    stringBuffer.append(genClass.getInterfaceExtends());
    }
    stringBuffer.append(TEXT_46);
    if (genModel.getCopyrightText() != null) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genModel.getCopyrightText());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_50);
    }
    if (isImplementation && genModel.getDriverNumber() != null) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(genModel.getDriverNumber());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_54);
    }
    if (isImplementation && genClass.isJavaIOSerializable()) {
    stringBuffer.append(TEXT_55);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_57);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) {
    for (Iterator i = eVirtualIndexBitFields.iterator(); i.hasNext();) { String eVirtualIndexBitField = (String)i.next();
    stringBuffer.append(TEXT_58);
    stringBuffer.append(eVirtualIndexBitField);
    stringBuffer.append(TEXT_59);
    }
    }
    }
    }
    if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled() && genModel.getBooleanFlagsReservedBits() == -1) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genModel.getBooleanFlagsField());
    stringBuffer.append(TEXT_61);
    }
    if (isImplementation && !genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_62);
    ClassImpl classImpl = (ClassImpl) genClass.getEcoreClass();
    List declaredProperties = classImpl.getDeclaredProperties();
    List extendedProperties = classImpl.getExtendedProperties();
    int declaredPropertiesCount = 0;
    int extendedPropertiesCount = 0;
    for (Iterator f=genClass.getAllGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next();
    if (declaredProperties.contains(genFeature.getEcoreFeature())){
    declaredPropertiesCount++;
    String featureValue = "";
       List allFeatures = genClass.getAllGenFeatures();
       int g = allFeatures.indexOf(genFeature);
       GenClass base = genClass.getBaseGenClass();
       if (base == null)
       {
         featureValue = Integer.toString(declaredProperties.indexOf(genFeature.getEcoreFeature()));
       } else {
         int baseCount = base.getFeatureCount();    
         if (g < baseCount)
         {
           featureValue = base.getClassName() + "." + genFeature.getUpperName();
         } else {
           String baseCountID = base.getClassName() + "." + "SDO_PROPERTY_COUNT";
           featureValue =  baseCountID + " + " + Integer.toString(declaredProperties.indexOf(genFeature.getEcoreFeature()));
          }
       }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(featureValue);
    stringBuffer.append(TEXT_65);
    } else if (extendedProperties.contains(genFeature.getEcoreFeature())){
    extendedPropertiesCount++;
    String featureValue = "";
       List allFeatures = genClass.getAllGenFeatures();
       int g = allFeatures.indexOf(genFeature);
       GenClass base = genClass.getBaseGenClass();
       if (base == null)
       {
         featureValue = Integer.toString(-1 - extendedProperties.indexOf(genFeature.getEcoreFeature()));
       } else {
         int baseCount = base.getFeatureCount();    
         if (g < baseCount)
         {
           featureValue = base.getClassName() + "." + genFeature.getUpperName();
         } else {
           String baseCountID = base.getClassName() + "." + "SDO_PROPERTY_COUNT";
           featureValue =  baseCountID + " + " + Integer.toString(-1 - extendedProperties.indexOf(genFeature.getEcoreFeature()));
          }
       }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(featureValue);
    stringBuffer.append(TEXT_68);
    }
    }
    String featureCount = "";
    GenClass base = genClass.getBaseGenClass();
    if (base == null)
    {
    featureCount = Integer.toString(declaredPropertiesCount);
    }
    else {
    String baseCountID = base.getClassName() + "." + "SDO_PROPERTY_COUNT";
    featureCount = baseCountID + " + " + Integer.toString(declaredPropertiesCount);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(featureCount);
    stringBuffer.append(TEXT_70);
    featureCount = "";
    base = genClass.getBaseGenClass();
    if (base == null)
    {
    featureCount = Integer.toString(extendedPropertiesCount*-1);
    }
    else {
    String baseCountID = base.getClassName() + "." + "EXTENDED_PROPERTY_COUNT";
    featureCount = baseCountID + " - " + Integer.toString(extendedPropertiesCount);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(featureCount);
    stringBuffer.append(TEXT_72);
    for (Iterator f=genClass.getAllGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next();
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_75);
    String featureValue = "";
    List allFeatures = genClass.getAllGenFeatures();
    int g = allFeatures.indexOf(genFeature);
    base = genClass.getBaseGenClass();
    if (base == null)
    {
    featureValue = Integer.toString(g);
    } else {
    int baseCount = base.getFeatureCount();
    if (g < baseCount)
    {
    featureValue = base.getClassName() + "." + genFeature.getUpperName();
    } else {
    String baseCountID = base.getClassName() + "." + "INTERNAL_PROPERTY_COUNT";
    featureValue =  baseCountID + " + " + Integer.toString(g - baseCount);
    }
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(featureValue);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    featureCount = "";
    base = genClass.getBaseGenClass();
    if (base == null)
    {
      featureCount = Integer.toString(genClass.getFeatureCount());
    } 
    else {
      String baseCountID = base.getClassName() + "." + "INTERNAL_PROPERTY_COUNT";
      featureCount = baseCountID + " + " + Integer.toString(genClass.getFeatureCount() - base.getFeatureCount());
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(featureCount);
    stringBuffer.append(TEXT_81);
    for (Iterator f=genClass.getAllGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next();
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    for (Iterator i=genClass.getDeclaredFieldGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genFeature.isListType() || genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genModel.getImportedName(genFeature.getType()));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_92);
    }
    if (genModel.isArrayAccessors() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_99);
    }
    } else {
    if (!genFeature.isVolatile() || !genModel.isReflectiveDelegation() && (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable())) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genFeature.getStaticDefaultValue());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genModel.getNonNLS(genFeature.getStaticDefaultValue()));
    stringBuffer.append(TEXT_108);
    }
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    if (genClass.getFlagIndex(genFeature) > 31 && genClass.getFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append("<< " + genClass.getFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_117);
    } else {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_125);
    }
    }
    }
    if (genClass.isESetField(genFeature)) {
    if (genClass.isESetFlag(genFeature)) {
    if (genClass.getESetFlagIndex(genFeature) > 31 && genClass.getESetFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append("<< " + genClass.getESetFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_132);
    } else {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_136);
    }
    }
    }
    //Class/declaredFieldGenFeature.override.javajetinc
    }
    if (isImplementation) { // create constructor 
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_138);
    for (Iterator i=genClass.getFlagGenFeatures("true").iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_141);
    }
    if (SDOGenUtil.hasChangeSummaryProperty(genClass)) {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(SDOGenUtil.getChangeSummaryProperty(genClass));
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genPackage.getImportedFactoryClassName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genPackage.getImportedFactoryInterfaceName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_148);
    }
    /*
     * Output getter and setter interfaces / impls
     */
    
    for (Iterator i=(isImplementation ? genClass.getImplementedGenFeatures() : genClass.getDeclaredGenFeatures()).iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_149);
    if (!isImplementation) {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_152);
    } else {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_155);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_160);
    } else {
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    if (!isImplementation) {
    stringBuffer.append(TEXT_171);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_173);
    } else {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    if (!isImplementation) {
    stringBuffer.append(TEXT_180);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_181);
    } else {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_183);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_185);
    } else {
    stringBuffer.append(TEXT_186);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    if (!isImplementation) {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_194);
    } else {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_202);
    }
    stringBuffer.append(TEXT_203);
    if (!isImplementation) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_206);
    } else {
    stringBuffer.append(TEXT_207);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_210);
    }
    }
    if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_213);
    if (genFeature.isListType()) {
    if (genFeature.isMapType()) { GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature(); GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature(); 
    stringBuffer.append(TEXT_214);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_215);
    stringBuffer.append(keyFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_216);
    } else {
    stringBuffer.append(TEXT_217);
    stringBuffer.append(keyFeature.getType());
    stringBuffer.append(TEXT_218);
    }
    stringBuffer.append(TEXT_219);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_220);
    stringBuffer.append(valueFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_221);
    } else {
    stringBuffer.append(TEXT_222);
    stringBuffer.append(valueFeature.getType());
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    } else if (!genFeature.isWrappedFeatureMapType() && !(genModel.isSuppressEMFMetaData() && "org.eclipse.emf.ecore.EObject".equals(genFeature.getQualifiedListItemType()))) {
    stringBuffer.append(TEXT_225);
    stringBuffer.append(genFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_226);
    }
    } else if (genFeature.isSetDefaultValue()) {
    stringBuffer.append(TEXT_227);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_228);
    }
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    stringBuffer.append(TEXT_230);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(reverseGenFeature.getFormattedName());
    stringBuffer.append(TEXT_234);
    }
    }
    stringBuffer.append(TEXT_235);
    if (!genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_236);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    if (genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_240);
    stringBuffer.append(genFeature.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_244);
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_246);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_247);
    }
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_248);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_249);
    }
    }
    if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_250);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_251);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_252);
    }
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_253);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_255);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_256);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    }
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_258);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_259);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_260);
    }}
    stringBuffer.append(TEXT_261);
    } else {
    stringBuffer.append(TEXT_262);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_263);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_265);
    } else {
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_268);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_269);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_270);
    }
    stringBuffer.append(TEXT_271);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_273);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_274);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_275);
    }
    stringBuffer.append(TEXT_276);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_277);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_283);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_284);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_286);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_287);
    } else {
                if (genFeature.getType().equals("commonj.sdo.Sequence")){
    stringBuffer.append(TEXT_288);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_290);
    } else {
    stringBuffer.append(TEXT_291);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_294);
    }}
    stringBuffer.append(TEXT_295);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
    stringBuffer.append(TEXT_296);
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_297);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_298);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_299);
    } else {
    if (genFeature.isResolveProxies()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_300);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_303);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_304);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    }
    stringBuffer.append(TEXT_307);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_308);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_309);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_312);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_315);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_316);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_317);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_319);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_321);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_322);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_323);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_324);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_325);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.ChangeContext"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_328);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_329);
    }
    stringBuffer.append(TEXT_330);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_331);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_334);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_335);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_336);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_338);
    }
    stringBuffer.append(TEXT_339);
    } else if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_340);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_341);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_342);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_344);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_346);
    }
    stringBuffer.append(TEXT_347);
    }
    if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_349);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_350);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_351);
    }
    stringBuffer.append(TEXT_352);
    } else if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_353);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_354);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_355);
    } else {
    stringBuffer.append(TEXT_356);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_357);
    }
    }
    } else {//volatile
    if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_358);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_359);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_360);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_361);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_362);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_366);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_367);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); // AAAA
    if (genFeature.isFeatureMapType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_368);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_369);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_370);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_371);
    } else {
    stringBuffer.append(TEXT_372);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_375);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_376);
    }
    } else if (genFeature.isListType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_377);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_378);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_379);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_380);
    } else {
    stringBuffer.append(TEXT_381);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_383);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_384);
    }
    } else {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_385);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_386);
    }
    stringBuffer.append(TEXT_387);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_388);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_390);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_391);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_392);
    }
    stringBuffer.append(TEXT_393);
    } else {
    stringBuffer.append(TEXT_394);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_395);
    }
    stringBuffer.append(TEXT_396);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_397);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_398);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_399);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_400);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_401);
    }
    stringBuffer.append(TEXT_402);
    }
    }
    } else {
    stringBuffer.append(TEXT_403);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_404);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_405);
    //Class/getGenFeature.todo.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_406);
    }
    //Class/getGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
    stringBuffer.append(TEXT_407);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_408);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_409);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_410);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_411);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_412);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_413);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_414);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_415);
    } else {
    stringBuffer.append(TEXT_416);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_417);
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //BBBB
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_418);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_421);
    } else {
    stringBuffer.append(TEXT_422);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_423);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_424);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_425);
    }
    } else {
    stringBuffer.append(TEXT_426);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_427);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_428);
    //Class/basicGetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_429);
    //Class/basicGetGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_430);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_431);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_432);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_433);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_434);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_437);
    } else {
    stringBuffer.append(TEXT_438);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_439);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_441);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_442);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_443);
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_444);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_445);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_446);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_447);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_449);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_451);
    } else {
    stringBuffer.append(TEXT_452);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_454);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_455);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_456);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_457);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_458);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_459);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_460);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_461);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_462);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_463);
    } else {
    stringBuffer.append(TEXT_464);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_465);
    }
    stringBuffer.append(TEXT_466);
    } else {
    stringBuffer.append(TEXT_467);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_468);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_469);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_470);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_472);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_473);
    }
    stringBuffer.append(TEXT_474);
    }
    stringBuffer.append(TEXT_475);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //CCCC
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_476);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_477);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_478);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_479);
    } else {
    stringBuffer.append(TEXT_480);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_481);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_482);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_483);
    }
    } else {
    stringBuffer.append(TEXT_484);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_486);
    //Class/basicSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_487);
    //Class/basicSetGenFeature.override.javajetinc
    }
    if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
    if (isInterface) { 
    stringBuffer.append(TEXT_488);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_489);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_491);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_493);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_494);
    if (genFeature.isEnumType()) {
    stringBuffer.append(TEXT_495);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_496);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_497);
    }
    if (!genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_498);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_499);
    }
    }
    stringBuffer.append(TEXT_500);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_501);
    } else {
    stringBuffer.append(TEXT_502);
    }
    if (!isImplementation) { 
    stringBuffer.append(TEXT_503);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_505);
    } else {
    stringBuffer.append(TEXT_506);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_507);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_508);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_509);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_510);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_511);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_512);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_513);
    }
    stringBuffer.append(TEXT_514);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_515);
    }
    stringBuffer.append(TEXT_516);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_517);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_519);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_520);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(genFeature.getEObjectCast());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_523);
    stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
    stringBuffer.append(TEXT_524);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_525);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_527);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_528);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_529);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_530);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_532);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_533);
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_534);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_536);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_537);
    }
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_538);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_539);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_541);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_542);
    }
    stringBuffer.append(TEXT_543);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_544);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_545);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_546);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_547);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_548);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_551);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_552);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_553);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_554);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_556);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_557);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_559);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_560);
    }
    stringBuffer.append(TEXT_561);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_562);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_563);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_564);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_565);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_566);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_567);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_568);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_569);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_570);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_571);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_572);
    }
    stringBuffer.append(TEXT_573);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_575);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_576);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_577);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_578);
    }
    stringBuffer.append(TEXT_579);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_580);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_581);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_582);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_583);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_584);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_585);
    }
    stringBuffer.append(TEXT_586);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_587);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_588);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_589);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_590);
    }
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_591);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_592);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_593);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_595);
    }
    stringBuffer.append(TEXT_596);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_597);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_598);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_599);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_600);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_601);
    } else {
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_602);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_603);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_604);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_605);
    }
    }
    if (genFeature.isEnumType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_606);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_607);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_608);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_609);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_610);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_611);
    } else {
    stringBuffer.append(TEXT_612);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_613);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_614);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_615);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_616);
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_617);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_618);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_619);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_620);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_621);
    } else {
    stringBuffer.append(TEXT_622);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_623);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_624);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_625);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_626);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_627);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_628);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_629);
    }
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_630);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_631);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_632);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_633);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_635);
    }
    stringBuffer.append(TEXT_636);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_637);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_638);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_639);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_640);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_641);
    }
    stringBuffer.append(TEXT_642);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_643);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_644);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_645);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_646);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_647);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_648);
    }
    stringBuffer.append(TEXT_649);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_650);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_651);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_652);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_653);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_654);
    } else {
    stringBuffer.append(TEXT_655);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_656);
    }
    stringBuffer.append(TEXT_657);
    }
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_658);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_659);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_660);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_661);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_662);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_663);
    }
    stringBuffer.append(TEXT_664);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_665);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_666);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_667);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_668);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); // DDDD
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_669);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_670);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_671);
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_672);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_673);
    }
    stringBuffer.append(TEXT_674);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_675);
    }
    stringBuffer.append(TEXT_676);
    } else {
    stringBuffer.append(TEXT_677);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_678);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_679);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_680);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_681);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_682);
    }
    stringBuffer.append(TEXT_683);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_684);
    }
    stringBuffer.append(TEXT_685);
    }
    } else {
    stringBuffer.append(TEXT_686);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_687);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_688);
    //Class/setGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_689);
    }
    //Class/setGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
    stringBuffer.append(TEXT_690);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_691);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_692);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_693);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_694);
    } else {
    stringBuffer.append(TEXT_695);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_696);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_697);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_698);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_699);
    }
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_700);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_701);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_702);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_703);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_705);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_706);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_707);
    } else {
    stringBuffer.append(TEXT_708);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_709);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_710);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_711);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_712);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_713);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_714);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_715);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_716);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_717);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_718);
    } else {
    stringBuffer.append(TEXT_719);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_720);
    }
    stringBuffer.append(TEXT_721);
    } else {
    stringBuffer.append(TEXT_722);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_723);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_724);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_725);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_726);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_727);
    }
    stringBuffer.append(TEXT_728);
    }
    } else {
    stringBuffer.append(TEXT_729);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_730);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_731);
    //Class/basicUnsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_732);
    //Class.basicUnsetGenFeature.override.javajetinc
    }
    if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_733);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_734);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_735);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_736);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_737);
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_738);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_739);
    }
    stringBuffer.append(TEXT_740);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_741);
    if (!genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_742);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_743);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_744);
    }
    stringBuffer.append(TEXT_745);
    } else {
    stringBuffer.append(TEXT_746);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_747);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_748);
    } else {
    stringBuffer.append(TEXT_749);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_750);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_751);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_752);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    stringBuffer.append(TEXT_753);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_754);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_755);
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_756);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_757);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_758);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_759);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_760);
    }
    stringBuffer.append(TEXT_761);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_762);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_763);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_764);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_765);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_766);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_767);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_768);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_769);
    }
    stringBuffer.append(TEXT_770);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_771);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_772);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_773);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_774);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_775);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_776);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_777);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_778);
    }
    stringBuffer.append(TEXT_779);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_780);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_781);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_782);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_783);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_784);
    }
    stringBuffer.append(TEXT_785);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_786);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_787);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_788);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_789);
    }
    stringBuffer.append(TEXT_790);
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_791);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_792);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_793);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_795);
    }
    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_796);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_797);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_798);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_799);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_800);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_801);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_802);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_803);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_804);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_805);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_806);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_807);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_808);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_809);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_810);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_811);
    }
    }
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_812);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_813);
    if (!genModel.isVirtualDelegation()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_814);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_815);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_816);
    } else {
    stringBuffer.append(TEXT_817);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_818);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_819);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_820);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_821);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_822);
    } else {
    stringBuffer.append(TEXT_823);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_824);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_825);
    } else {
    stringBuffer.append(TEXT_826);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_827);
    }
    stringBuffer.append(TEXT_828);
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_829);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_830);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_831);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_832);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_834);
    } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_835);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_836);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_837);
    }
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_838);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_839);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_840);
    } else {
    stringBuffer.append(TEXT_841);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_842);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_843);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_844);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_845);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_846);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_847);
    } else {
    stringBuffer.append(TEXT_848);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_849);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_850);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_851);
    } else {
    stringBuffer.append(TEXT_852);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_853);
    }
    stringBuffer.append(TEXT_854);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //EEEE
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_855);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_856);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_857);
    } else {
    stringBuffer.append(TEXT_858);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_859);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_860);
    }
    } else {
    stringBuffer.append(TEXT_861);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_862);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_863);
    //Class/unsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_864);
    }
    //Class/unsetGenFeature.override.javajetinc
    }
    if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_865);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_866);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_867);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_868);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_869);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_870);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_871);
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_872);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_873);
    }
    stringBuffer.append(TEXT_874);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_875);
    if (!genFeature.isListType() && genFeature.isChangeable() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_876);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_877);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_878);
    }
    stringBuffer.append(TEXT_879);
    } else {
    stringBuffer.append(TEXT_880);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_881);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_882);
    } else {
    stringBuffer.append(TEXT_883);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_884);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_885);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_886);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_887);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_888);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_889);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_890);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_891);
    }
    stringBuffer.append(TEXT_892);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_893);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_894);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_895);
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_896);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_897);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_898);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_899);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_900);
    } else {
    stringBuffer.append(TEXT_901);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_902);
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //FFFF
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_903);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_904);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_905);
    } else {
    stringBuffer.append(TEXT_906);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_907);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_908);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_909);
    }
    } else {
    stringBuffer.append(TEXT_910);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_911);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_912);
    //Class/isSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_913);
    }
    //Class/isSetGenFeature.override.javajetinc
    }
    //Class/genFeature.override.javajetinc
    }// end output getter and setter interfaces or impls
    for (Iterator i= (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations()).iterator(); i.hasNext();) { GenOperation genOperation = (GenOperation)i.next();
    if (isInterface) {
    stringBuffer.append(TEXT_914);
    if (genOperation.hasDocumentation()) {
    stringBuffer.append(TEXT_915);
    stringBuffer.append(genOperation.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_916);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genOperation.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_917);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_918);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_919);
    }}
    stringBuffer.append(TEXT_920);
    } else {
    stringBuffer.append(TEXT_921);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_922);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_923);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_924);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_925);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_926);
    } else {
    stringBuffer.append(TEXT_927);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_928);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_929);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_930);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_931);
    if (genOperation.hasBody()) {
    stringBuffer.append(TEXT_932);
    stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
    } else if (genOperation.isInvariant()) {GenClass opClass = genOperation.getGenClass(); String diagnostics = ((GenParameter)genOperation.getGenParameters().get(0)).getName(); String context = ((GenParameter)genOperation.getGenParameters().get(1)).getName();
    stringBuffer.append(TEXT_933);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
    stringBuffer.append(TEXT_937);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_938);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_939);
    stringBuffer.append(opClass.getOperationID(genOperation));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
    stringBuffer.append(TEXT_941);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_942);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_945);
    } else {
    stringBuffer.append(TEXT_946);
    //Class/implementedGenOperation.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_947);
    }
    //Class/implementedGenOperation.override.javajetinc
    }//for
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
    stringBuffer.append(TEXT_948);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_949);
    for (Iterator i=genClass.getEInverseAddGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_950);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_951);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_952);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_955);
    } else {
    stringBuffer.append(TEXT_956);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_957);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_958);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_959);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_960);
    } else {
    if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_961);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_962);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_963);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_964);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_965);
    }
    stringBuffer.append(TEXT_966);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_967);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_968);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_969);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_970);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_971);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_972);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_973);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_974);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_976);
    }
    stringBuffer.append(TEXT_977);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_978);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_979);
    }
    }
    }
    stringBuffer.append(TEXT_980);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_981);
    } else {
    stringBuffer.append(TEXT_982);
    }
    stringBuffer.append(TEXT_983);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
    stringBuffer.append(TEXT_984);
    stringBuffer.append(genModel.getImportedName("java.lang.Object"));
    stringBuffer.append(TEXT_985);
    for (Iterator i=genClass.getEInverseRemoveGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_986);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_987);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_988);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_991);
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_992);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_993);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_994);
    } else {
    stringBuffer.append(TEXT_995);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_996);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_997);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_998);
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_999);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1000);
    } else {
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1002);
    }
    }
    }
    stringBuffer.append(TEXT_1003);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1004);
    } else {
    stringBuffer.append(TEXT_1005);
    }
    stringBuffer.append(TEXT_1006);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
    stringBuffer.append(TEXT_1007);
    for (Iterator i=genClass.getEBasicRemoveFromContainerGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1011);
    }
    }
    stringBuffer.append(TEXT_1012);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1013);
    } else {
    stringBuffer.append(TEXT_1014);
    }
    stringBuffer.append(TEXT_1015);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1016);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1018);
    if (genFeature.isPrimitiveType()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1020);
    } else {
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1023);
    }
    } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1026);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1030);
    } else {
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1033);
    }
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1035);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1039);
    } else {
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1041);
    }
    }
    }
    stringBuffer.append(TEXT_1042);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1043);
    } else {
    stringBuffer.append(TEXT_1044);
    }
    stringBuffer.append(TEXT_1045);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
    stringBuffer.append(TEXT_1046);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1048);
    if (genFeature.isListType()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1051);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1054);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1058);
    } else {
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1061);
    }
    } else {
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1065);
    }
    } else if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1069);
    } else {
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1072);
    }
    stringBuffer.append(TEXT_1073);
    }
    }
    stringBuffer.append(TEXT_1074);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1075);
    } else {
    stringBuffer.append(TEXT_1076);
    }
    stringBuffer.append(TEXT_1077);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1079);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1082);
    } else {
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1084);
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1086);
    } else if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1089);
    } else {
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1092);
    }
    stringBuffer.append(TEXT_1093);
    }
    }
    stringBuffer.append(TEXT_1094);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1095);
    } else {
    stringBuffer.append(TEXT_1096);
    }
    stringBuffer.append(TEXT_1097);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1098);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1100);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1103);
    } else {
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1107);
    }
    } else {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1110);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1117);
    } else {
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1119);
    }
    }
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1121);
    } else if (genFeature.isResolveProxies()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1123);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1125);
    } else {
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1127);
    }
    }
    } else if (genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1129);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1131);
    } else {
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1133);
    }
    }
    } else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1137);
    } else {
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1140);
    }
    } else {
    if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1144);
    } else {
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1147);
    }
    }
    } else {//datatype
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1152);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1162);
    } else {
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1167);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1168);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1169);
    } else {
    stringBuffer.append(TEXT_1170);
    }
    stringBuffer.append(TEXT_1171);
    //Class/eIsSet.override.javajetinc
    }
    if (isImplementation && !genClass.getMixinGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1172);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1174);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1177);
    }
    stringBuffer.append(TEXT_1178);
    }
    stringBuffer.append(TEXT_1179);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1181);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1184);
    }
    stringBuffer.append(TEXT_1185);
    }
    stringBuffer.append(TEXT_1186);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1189);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) { List allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList());
    stringBuffer.append(TEXT_1190);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1193);
    }
    stringBuffer.append(TEXT_1194);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1197);
    }
    stringBuffer.append(TEXT_1198);
    }
    }
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1199);
    { boolean first = true;
    for (Iterator i=genClass.getToStringGenFeatures().iterator(); i.hasNext(); ) { GenFeature genFeature = (GenFeature)i.next();
    if (first) { first = false;
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.isUnsettable() && !genFeature.isListType()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1207);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1210);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1211);
    }
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1215);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1218);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1219);
    }
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isListType() && !genFeature.isReferenceType()){
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1224);
    }
    stringBuffer.append(TEXT_1225);
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1228);
    } else {
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1230);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1231);
    }
    if (isImplementation && genClass.isMapEntry()) { GenFeature keyFeature = genClass.getMapEntryKeyFeature(); GenFeature valueFeature = genClass.getMapEntryValueFeature();
    stringBuffer.append(TEXT_1232);
    if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1234);
    } else {
    stringBuffer.append(TEXT_1235);
    }
    stringBuffer.append(TEXT_1236);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1238);
    } else if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(keyFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1241);
    } else {
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(keyFeature.getImportedType());
    stringBuffer.append(TEXT_1243);
    }
    stringBuffer.append(TEXT_1244);
    if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1246);
    } else {
    stringBuffer.append(TEXT_1247);
    }
    stringBuffer.append(TEXT_1248);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1250);
    } else if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(valueFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1253);
    } else {
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(valueFeature.getImportedType());
    stringBuffer.append(TEXT_1255);
    }
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1259);
    }
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
    // TODO fix the space above
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_1261);
    return stringBuffer.toString();
  }
}
