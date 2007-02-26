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
  protected final String TEXT_18 = NL + " *   <li>{@link ";
  protected final String TEXT_19 = "#";
  protected final String TEXT_20 = " <em>";
  protected final String TEXT_21 = "</em>}</li>";
  protected final String TEXT_22 = NL + " * </ul>" + NL + " * </p>";
  protected final String TEXT_23 = NL + " *";
  protected final String TEXT_24 = NL + " * @see ";
  protected final String TEXT_25 = "#get";
  protected final String TEXT_26 = "()";
  protected final String TEXT_27 = NL + " * @model ";
  protected final String TEXT_28 = NL + " *        ";
  protected final String TEXT_29 = NL + " * @model";
  protected final String TEXT_30 = NL + " * @extends ";
  protected final String TEXT_31 = NL + " * @generated" + NL + " */";
  protected final String TEXT_32 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model object '<em><b>";
  protected final String TEXT_33 = "</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>";
  protected final String TEXT_34 = NL + " * The following features are implemented:" + NL + " * <ul>";
  protected final String TEXT_35 = NL + " *   <li>{@link ";
  protected final String TEXT_36 = "#";
  protected final String TEXT_37 = " <em>";
  protected final String TEXT_38 = "</em>}</li>";
  protected final String TEXT_39 = NL + " * </ul>";
  protected final String TEXT_40 = NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */";
  protected final String TEXT_41 = NL + "public";
  protected final String TEXT_42 = " abstract";
  protected final String TEXT_43 = " class ";
  protected final String TEXT_44 = NL + "public interface ";
  protected final String TEXT_45 = NL + "{";
  protected final String TEXT_46 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_47 = " copyright = \"";
  protected final String TEXT_48 = "\";";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_51 = " mofDriverNumber = \"";
  protected final String TEXT_52 = "\";";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL;
  protected final String TEXT_55 = NL + "\t/**" + NL + "\t * An array of objects representing the values of non-primitive features." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] ";
  protected final String TEXT_56 = " = null;" + NL;
  protected final String TEXT_57 = NL + "\t/**" + NL + "\t * A bit field representing the indices of non-primitive feature values." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_58 = " = 0;" + NL;
  protected final String TEXT_59 = NL + "\t/**" + NL + "\t * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_60 = " = 0;" + NL;
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = NL + "\tpublic final static int ";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL;
  protected final String TEXT_65 = NL + "\tpublic final static int ";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ";" + NL;
  protected final String TEXT_68 = NL + "\tpublic final static int SDO_PROPERTY_COUNT = ";
  protected final String TEXT_69 = ";" + NL;
  protected final String TEXT_70 = NL + "\tpublic final static int EXTENDED_PROPERTY_COUNT = ";
  protected final String TEXT_71 = ";" + NL + NL;
  protected final String TEXT_72 = NL + "\t/**" + NL + "\t * The internal feature id for the '<em><b>";
  protected final String TEXT_73 = "</b></em>' ";
  protected final String TEXT_74 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_75 = " " + NL + "\tpublic final static int INTERNAL_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL;
  protected final String TEXT_78 = NL + "\t/**" + NL + "\t * The number of properties for this type." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_79 = NL + "\tpublic final static int INTERNAL_PROPERTY_COUNT = ";
  protected final String TEXT_80 = ";" + NL + "" + NL + "\tprotected int internalConvertIndex(int internalIndex)" + NL + "\t{" + NL + "\t\tswitch (internalIndex)" + NL + "\t\t{";
  protected final String TEXT_81 = NL + "\t\t\tcase INTERNAL_";
  protected final String TEXT_82 = ": return ";
  protected final String TEXT_83 = ";";
  protected final String TEXT_84 = NL + "\t\t}" + NL + "\t\treturn super.internalConvertIndex(internalIndex);" + NL + "\t}" + NL + NL;
  protected final String TEXT_85 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_86 = "() <em>";
  protected final String TEXT_87 = "</em>}' ";
  protected final String TEXT_88 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_89 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t" + NL + "\tprotected ";
  protected final String TEXT_90 = " ";
  protected final String TEXT_91 = " = null;" + NL + "\t";
  protected final String TEXT_92 = NL + "\t/**" + NL + "\t * The empty value for the '{@link #";
  protected final String TEXT_93 = "() <em>";
  protected final String TEXT_94 = "</em>}' array accessor." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_95 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_96 = "[] ";
  protected final String TEXT_97 = "_EEMPTY_ARRAY = new ";
  protected final String TEXT_98 = " [0];" + NL;
  protected final String TEXT_99 = NL + "\t/**" + NL + "\t * The default value of the '{@link #";
  protected final String TEXT_100 = "() <em>";
  protected final String TEXT_101 = "</em>}' ";
  protected final String TEXT_102 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_103 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_104 = " ";
  protected final String TEXT_105 = "_DEFAULT_ = ";
  protected final String TEXT_106 = ";";
  protected final String TEXT_107 = NL;
  protected final String TEXT_108 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_109 = " = 0;" + NL;
  protected final String TEXT_110 = NL + "\t/**" + NL + "\t * The flag representing the value of the '{@link #";
  protected final String TEXT_111 = "() <em>";
  protected final String TEXT_112 = "</em>}' ";
  protected final String TEXT_113 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_114 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_115 = "_EFLAG = 1 ";
  protected final String TEXT_116 = ";" + NL;
  protected final String TEXT_117 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_118 = "() <em>";
  protected final String TEXT_119 = "</em>}' ";
  protected final String TEXT_120 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_121 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_122 = " ";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = "_DEFAULT_;" + NL;
  protected final String TEXT_125 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_126 = " = 0;" + NL;
  protected final String TEXT_127 = NL + "\t/**" + NL + "\t * The flag representing whether the ";
  protected final String TEXT_128 = " ";
  protected final String TEXT_129 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_130 = "_ESETFLAG = 1 ";
  protected final String TEXT_131 = ";" + NL;
  protected final String TEXT_132 = NL + "\t/**" + NL + "\t * This is true if the ";
  protected final String TEXT_133 = " ";
  protected final String TEXT_134 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected boolean ";
  protected final String TEXT_135 = "_set_ = false;" + NL;
  protected final String TEXT_136 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_137 = "()" + NL + "\t{" + NL + "\t\tsuper();";
  protected final String TEXT_138 = NL + "\t\t";
  protected final String TEXT_139 = " |= ";
  protected final String TEXT_140 = "_EFLAG;";
  protected final String TEXT_141 = NL + "\t\tcreateChangeSummary(";
  protected final String TEXT_142 = ");";
  protected final String TEXT_143 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_144 = " getType()" + NL + "\t{" + NL + "\t\treturn ((";
  protected final String TEXT_145 = ")";
  protected final String TEXT_146 = ".INSTANCE).get";
  protected final String TEXT_147 = "();" + NL + "\t}" + NL;
  protected final String TEXT_148 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_149 = NL + "\t";
  protected final String TEXT_150 = "[] ";
  protected final String TEXT_151 = "();" + NL;
  protected final String TEXT_152 = NL + "\tpublic ";
  protected final String TEXT_153 = "[] ";
  protected final String TEXT_154 = "()" + NL + "\t{";
  protected final String TEXT_155 = NL + "\t\t";
  protected final String TEXT_156 = " list = (";
  protected final String TEXT_157 = ")";
  protected final String TEXT_158 = "();" + NL + "\t\tif (list.isEmpty()) return ";
  protected final String TEXT_159 = "_EEMPTY_ARRAY;";
  protected final String TEXT_160 = NL + "\t\tif (";
  protected final String TEXT_161 = " == null || ";
  protected final String TEXT_162 = ".isEmpty()) return ";
  protected final String TEXT_163 = "_EEMPTY_ARRAY;" + NL + "\t\t";
  protected final String TEXT_164 = " list = (";
  protected final String TEXT_165 = ")";
  protected final String TEXT_166 = ";";
  protected final String TEXT_167 = NL + "\t\tlist.shrink();" + NL + "\t\treturn (";
  protected final String TEXT_168 = "[])list.data();" + NL + "\t}" + NL;
  protected final String TEXT_169 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_170 = NL + "\t";
  protected final String TEXT_171 = " get";
  protected final String TEXT_172 = "(int index);";
  protected final String TEXT_173 = NL + "\tpublic ";
  protected final String TEXT_174 = " get";
  protected final String TEXT_175 = "(int index)" + NL + "\t{" + NL + "\t\treturn (";
  protected final String TEXT_176 = ")";
  protected final String TEXT_177 = "().get(index);" + NL + "\t}";
  protected final String TEXT_178 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_179 = NL + "\tint get";
  protected final String TEXT_180 = "Length();" + NL;
  protected final String TEXT_181 = NL + "\tpublic int get";
  protected final String TEXT_182 = "Length()" + NL + "\t{";
  protected final String TEXT_183 = NL + "\t\treturn ";
  protected final String TEXT_184 = "().size();";
  protected final String TEXT_185 = NL + "\t\treturn ";
  protected final String TEXT_186 = " == null ? 0 : ";
  protected final String TEXT_187 = ".size();";
  protected final String TEXT_188 = NL + "\t}" + NL;
  protected final String TEXT_189 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_190 = NL + "\tvoid set";
  protected final String TEXT_191 = "(";
  protected final String TEXT_192 = "[] new";
  protected final String TEXT_193 = ");" + NL;
  protected final String TEXT_194 = NL + "\tpublic void set";
  protected final String TEXT_195 = "(";
  protected final String TEXT_196 = "[] new";
  protected final String TEXT_197 = ")" + NL + "\t{" + NL + "\t\t((";
  protected final String TEXT_198 = ")";
  protected final String TEXT_199 = "()).setData(new";
  protected final String TEXT_200 = ".length, new";
  protected final String TEXT_201 = ");" + NL + "\t}" + NL;
  protected final String TEXT_202 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_203 = NL + "\tvoid set";
  protected final String TEXT_204 = "(int index, ";
  protected final String TEXT_205 = " element);" + NL;
  protected final String TEXT_206 = NL + "\tpublic void set";
  protected final String TEXT_207 = "(int index, ";
  protected final String TEXT_208 = " element)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_209 = "().set(index, element);" + NL + "\t}" + NL;
  protected final String TEXT_210 = NL + "\t/**" + NL + "\t * Returns the value of the '<em><b>";
  protected final String TEXT_211 = "</b></em>' ";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = NL + "\t * The key is of type ";
  protected final String TEXT_214 = "list of {@link ";
  protected final String TEXT_215 = "}";
  protected final String TEXT_216 = "{@link ";
  protected final String TEXT_217 = "}";
  protected final String TEXT_218 = "," + NL + "\t * and the value is of type ";
  protected final String TEXT_219 = "list of {@link ";
  protected final String TEXT_220 = "}";
  protected final String TEXT_221 = "{@link ";
  protected final String TEXT_222 = "}";
  protected final String TEXT_223 = ",";
  protected final String TEXT_224 = NL + "\t * The list contents are of type {@link ";
  protected final String TEXT_225 = "}.";
  protected final String TEXT_226 = NL + "\t * The default value is <code>";
  protected final String TEXT_227 = "</code>.";
  protected final String TEXT_228 = NL + "\t * The literals are from the enumeration {@link ";
  protected final String TEXT_229 = "}.";
  protected final String TEXT_230 = NL + "\t * It is bidirectional and its opposite is '{@link ";
  protected final String TEXT_231 = "#";
  protected final String TEXT_232 = " <em>";
  protected final String TEXT_233 = "</em>}'.";
  protected final String TEXT_234 = NL + "\t * <!-- begin-user-doc -->";
  protected final String TEXT_235 = NL + "\t * <p>" + NL + "\t * If the meaning of the '<em>";
  protected final String TEXT_236 = "</em>' ";
  protected final String TEXT_237 = " isn't clear," + NL + "\t * there really should be more of a description here..." + NL + "\t * </p>";
  protected final String TEXT_238 = NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_239 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_240 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_241 = NL + "\t * @return the value of the '<em>";
  protected final String TEXT_242 = "</em>' ";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = NL + "\t * @see ";
  protected final String TEXT_245 = NL + "\t * @see #isSet";
  protected final String TEXT_246 = "()";
  protected final String TEXT_247 = NL + "\t * @see #unset";
  protected final String TEXT_248 = "()";
  protected final String TEXT_249 = NL + "\t * @see #set";
  protected final String TEXT_250 = "(";
  protected final String TEXT_251 = ")";
  protected final String TEXT_252 = NL + "\t * @see ";
  protected final String TEXT_253 = "#get";
  protected final String TEXT_254 = "()";
  protected final String TEXT_255 = NL + "\t * @see ";
  protected final String TEXT_256 = "#";
  protected final String TEXT_257 = NL + "\t * @model ";
  protected final String TEXT_258 = NL + "\t *        ";
  protected final String TEXT_259 = NL + "\t * @model";
  protected final String TEXT_260 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_261 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_262 = NL + "\t";
  protected final String TEXT_263 = " ";
  protected final String TEXT_264 = "();" + NL;
  protected final String TEXT_265 = NL + "\tpublic ";
  protected final String TEXT_266 = " ";
  protected final String TEXT_267 = "()" + NL + "\t{";
  protected final String TEXT_268 = NL + "\t\treturn ";
  protected final String TEXT_269 = "(";
  protected final String TEXT_270 = "(";
  protected final String TEXT_271 = ")get(";
  protected final String TEXT_272 = ", true)";
  protected final String TEXT_273 = ").";
  protected final String TEXT_274 = "()";
  protected final String TEXT_275 = ";";
  protected final String TEXT_276 = NL + "\t\t";
  protected final String TEXT_277 = " ";
  protected final String TEXT_278 = " = (";
  protected final String TEXT_279 = ")eVirtualGet(";
  protected final String TEXT_280 = ");";
  protected final String TEXT_281 = NL + "\t\tif (";
  protected final String TEXT_282 = " == null)" + NL + "\t\t{";
  protected final String TEXT_283 = NL + "\t\t\teVirtualSet(";
  protected final String TEXT_284 = ", ";
  protected final String TEXT_285 = " = new ";
  protected final String TEXT_286 = ");";
  protected final String TEXT_287 = NL + "\t\t  ";
  protected final String TEXT_288 = " = createSequence(INTERNAL_";
  protected final String TEXT_289 = ");";
  protected final String TEXT_290 = NL + "\t\t  ";
  protected final String TEXT_291 = " = createPropertyList(ListKind.CONTAINMENT, ";
  protected final String TEXT_292 = ".class, ";
  protected final String TEXT_293 = ");";
  protected final String TEXT_294 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_295 = ";";
  protected final String TEXT_296 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_297 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_298 = ")eContainer();";
  protected final String TEXT_299 = NL + "\t\t";
  protected final String TEXT_300 = " ";
  protected final String TEXT_301 = " = (";
  protected final String TEXT_302 = ")eVirtualGet(";
  protected final String TEXT_303 = ", ";
  protected final String TEXT_304 = "_DEFAULT_";
  protected final String TEXT_305 = ");";
  protected final String TEXT_306 = NL + "\t\tif (";
  protected final String TEXT_307 = " != null && isProxy(";
  protected final String TEXT_308 = "))" + NL + "\t\t{" + NL + "\t\t\tObject old";
  protected final String TEXT_309 = " = ";
  protected final String TEXT_310 = ";" + NL + "\t\t\t";
  protected final String TEXT_311 = " = ";
  protected final String TEXT_312 = "resolveProxy(old";
  protected final String TEXT_313 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_314 = " != old";
  protected final String TEXT_315 = ")" + NL + "\t\t\t{";
  protected final String TEXT_316 = NL + "\t\t\t\t";
  protected final String TEXT_317 = " new";
  protected final String TEXT_318 = " = (";
  protected final String TEXT_319 = ")";
  protected final String TEXT_320 = ";";
  protected final String TEXT_321 = NL + "\t\t\t\tChangeContext changeContext = old";
  protected final String TEXT_322 = ".inverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_323 = ", null, null);";
  protected final String TEXT_324 = NL + "\t\t\t\t";
  protected final String TEXT_325 = " changeContext =  old";
  protected final String TEXT_326 = ".inverseRemove(this, ";
  protected final String TEXT_327 = ", ";
  protected final String TEXT_328 = ".class, null);";
  protected final String TEXT_329 = NL + "\t\t\t\tif (new";
  protected final String TEXT_330 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
  protected final String TEXT_331 = NL + "\t\t\t\t\tchangeContext = new";
  protected final String TEXT_332 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_333 = ", null, changeContext);";
  protected final String TEXT_334 = NL + "\t\t\t\t\tchangeContext =  new";
  protected final String TEXT_335 = ".eInverseAdd(this, ";
  protected final String TEXT_336 = ", ";
  protected final String TEXT_337 = ".class, changeContext);";
  protected final String TEXT_338 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (changeContext != null) dispatch(changeContext);";
  protected final String TEXT_339 = NL + "\t\t\t\teVirtualSet(";
  protected final String TEXT_340 = ", ";
  protected final String TEXT_341 = ");";
  protected final String TEXT_342 = NL + "\t\t\t\tif (isNotifying())" + NL + "\t\t\t\t\tnotify(ChangeKind.RESOLVE, ";
  protected final String TEXT_343 = ", old";
  protected final String TEXT_344 = ", ";
  protected final String TEXT_345 = ");";
  protected final String TEXT_346 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_347 = NL + "\t\treturn (";
  protected final String TEXT_348 = ")eVirtualGet(";
  protected final String TEXT_349 = ", ";
  protected final String TEXT_350 = "_DEFAULT_";
  protected final String TEXT_351 = ");";
  protected final String TEXT_352 = NL + "\t\treturn (";
  protected final String TEXT_353 = " & ";
  protected final String TEXT_354 = "_EFLAG) != 0;";
  protected final String TEXT_355 = NL + "\t\treturn ";
  protected final String TEXT_356 = ";";
  protected final String TEXT_357 = NL + "\t\t";
  protected final String TEXT_358 = " ";
  protected final String TEXT_359 = " = basicGet";
  protected final String TEXT_360 = "();" + NL + "\t\treturn ";
  protected final String TEXT_361 = " != null && ";
  protected final String TEXT_362 = ".isProxy() ? ";
  protected final String TEXT_363 = "eResolveProxy((";
  protected final String TEXT_364 = ")";
  protected final String TEXT_365 = ") : ";
  protected final String TEXT_366 = ";";
  protected final String TEXT_367 = NL + "\t\treturn create";
  protected final String TEXT_368 = "(get";
  protected final String TEXT_369 = "(), getType(), ";
  protected final String TEXT_370 = ");";
  protected final String TEXT_371 = NL + "\t\treturn (";
  protected final String TEXT_372 = ")((";
  protected final String TEXT_373 = ")get";
  protected final String TEXT_374 = "()).list(";
  protected final String TEXT_375 = ");";
  protected final String TEXT_376 = NL + "          return get";
  protected final String TEXT_377 = "(get";
  protected final String TEXT_378 = "(), getType(), ";
  protected final String TEXT_379 = ");" + NL;
  protected final String TEXT_380 = NL + "\t\treturn ((";
  protected final String TEXT_381 = ")get";
  protected final String TEXT_382 = "()).list(";
  protected final String TEXT_383 = ");";
  protected final String TEXT_384 = NL + "\t\treturn ";
  protected final String TEXT_385 = "(";
  protected final String TEXT_386 = "(";
  protected final String TEXT_387 = ")get(get";
  protected final String TEXT_388 = "(), getType(), INTERNAL_";
  protected final String TEXT_389 = ")";
  protected final String TEXT_390 = ").";
  protected final String TEXT_391 = "()";
  protected final String TEXT_392 = ";";
  protected final String TEXT_393 = NL + "\t\treturn ";
  protected final String TEXT_394 = "(";
  protected final String TEXT_395 = "(";
  protected final String TEXT_396 = ")get(get";
  protected final String TEXT_397 = "(), getType(), INTERNAL_";
  protected final String TEXT_398 = ");";
  protected final String TEXT_399 = ").";
  protected final String TEXT_400 = "()";
  protected final String TEXT_401 = ";";
  protected final String TEXT_402 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_403 = "' ";
  protected final String TEXT_404 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_405 = NL + "\t}";
  protected final String TEXT_406 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_407 = " basicGet";
  protected final String TEXT_408 = "()" + NL + "\t{";
  protected final String TEXT_409 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_410 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_411 = ")eInternalContainer();";
  protected final String TEXT_412 = NL + "\t\treturn (";
  protected final String TEXT_413 = ")eVirtualGet(";
  protected final String TEXT_414 = ");";
  protected final String TEXT_415 = NL + "\t\treturn ";
  protected final String TEXT_416 = ";";
  protected final String TEXT_417 = NL + "\t\treturn (";
  protected final String TEXT_418 = ")get(get";
  protected final String TEXT_419 = "(), getType(), ";
  protected final String TEXT_420 = ");";
  protected final String TEXT_421 = NL + "\t\treturn (";
  protected final String TEXT_422 = ")get";
  protected final String TEXT_423 = "().get(";
  protected final String TEXT_424 = ", false);";
  protected final String TEXT_425 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_426 = "' ";
  protected final String TEXT_427 = NL + "\t\t// -> do not perform proxy resolution" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_428 = NL + "\t}" + NL;
  protected final String TEXT_429 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicSet";
  protected final String TEXT_430 = "(";
  protected final String TEXT_431 = " new";
  protected final String TEXT_432 = ", ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_433 = NL + "\t\tObject old";
  protected final String TEXT_434 = " = eVirtualSet(";
  protected final String TEXT_435 = ", new";
  protected final String TEXT_436 = ");";
  protected final String TEXT_437 = NL + "\t\t";
  protected final String TEXT_438 = " old";
  protected final String TEXT_439 = " = ";
  protected final String TEXT_440 = ";" + NL + "\t\t";
  protected final String TEXT_441 = " = new";
  protected final String TEXT_442 = ";";
  protected final String TEXT_443 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_444 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_445 = NL + "\t\tboolean old";
  protected final String TEXT_446 = "_set_ = (";
  protected final String TEXT_447 = " & ";
  protected final String TEXT_448 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_449 = " |= ";
  protected final String TEXT_450 = "_ESETFLAG;";
  protected final String TEXT_451 = NL + "\t\tboolean old";
  protected final String TEXT_452 = "_set_ = ";
  protected final String TEXT_453 = "_set_;" + NL + "\t\t";
  protected final String TEXT_454 = "_set_ = true;";
  protected final String TEXT_455 = NL + "\t\tif (isNotifying())" + NL + "\t\t{";
  protected final String TEXT_456 = NL + "\t\t\taddNotification(this, ChangeKind.SET, ";
  protected final String TEXT_457 = ", ";
  protected final String TEXT_458 = "isSetChange ? null : old";
  protected final String TEXT_459 = "old";
  protected final String TEXT_460 = ", new";
  protected final String TEXT_461 = ", ";
  protected final String TEXT_462 = "isSetChange";
  protected final String TEXT_463 = "!old";
  protected final String TEXT_464 = "_set_";
  protected final String TEXT_465 = ", changeContext);";
  protected final String TEXT_466 = NL + "\t\t\taddNotification(this, ChangeKind.SET, ";
  protected final String TEXT_467 = ", ";
  protected final String TEXT_468 = "old";
  protected final String TEXT_469 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_470 = "old";
  protected final String TEXT_471 = ", new";
  protected final String TEXT_472 = ", changeContext);";
  protected final String TEXT_473 = NL + "\t\t}";
  protected final String TEXT_474 = NL + "\t\treturn changeContext;";
  protected final String TEXT_475 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_476 = "(), getType(), ";
  protected final String TEXT_477 = ", new";
  protected final String TEXT_478 = ", changeContext);";
  protected final String TEXT_479 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_480 = "(), getType(), ";
  protected final String TEXT_481 = ", new";
  protected final String TEXT_482 = ", changeContext);";
  protected final String TEXT_483 = NL + "\t\t// TODO: implement this method to set the contained '";
  protected final String TEXT_484 = "' ";
  protected final String TEXT_485 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_486 = NL + "\t}" + NL;
  protected final String TEXT_487 = NL + "\t/**" + NL + "\t * Sets the value of the '{@link ";
  protected final String TEXT_488 = "#";
  protected final String TEXT_489 = " <em>";
  protected final String TEXT_490 = "</em>}' ";
  protected final String TEXT_491 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param value the new value of the '<em>";
  protected final String TEXT_492 = "</em>' ";
  protected final String TEXT_493 = ".";
  protected final String TEXT_494 = NL + "\t * @see ";
  protected final String TEXT_495 = NL + "\t * @see #isSet";
  protected final String TEXT_496 = "()";
  protected final String TEXT_497 = NL + "\t * @see #unset";
  protected final String TEXT_498 = "()";
  protected final String TEXT_499 = NL + "\t * @see #";
  protected final String TEXT_500 = "()" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_501 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_502 = NL + "\tvoid set";
  protected final String TEXT_503 = "(";
  protected final String TEXT_504 = " value);" + NL;
  protected final String TEXT_505 = NL + "\tpublic void set";
  protected final String TEXT_506 = "(";
  protected final String TEXT_507 = " new";
  protected final String TEXT_508 = ")" + NL + "\t{";
  protected final String TEXT_509 = NL + "\t\t_set_(";
  protected final String TEXT_510 = ", ";
  protected final String TEXT_511 = "new ";
  protected final String TEXT_512 = "(";
  protected final String TEXT_513 = "new";
  protected final String TEXT_514 = ")";
  protected final String TEXT_515 = ");";
  protected final String TEXT_516 = NL + "\t\tif (new";
  protected final String TEXT_517 = " != eInternalContainer() || (eContainerFeatureID != ";
  protected final String TEXT_518 = " && new";
  protected final String TEXT_519 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_520 = ".isAncestor(this, ";
  protected final String TEXT_521 = "new";
  protected final String TEXT_522 = "))" + NL + "\t\t\t\tthrow new ";
  protected final String TEXT_523 = "(\"Recursive containment not allowed for \" + toString());";
  protected final String TEXT_524 = NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_525 = " != null)" + NL + "\t\t\t\tchangeContext = ((";
  protected final String TEXT_526 = ")new";
  protected final String TEXT_527 = ").eInverseAdd(this, ";
  protected final String TEXT_528 = ", ";
  protected final String TEXT_529 = ".class, changeContext);" + NL + "\t\t\tchangeContext = eBasicSetContainer((";
  protected final String TEXT_530 = ")new";
  protected final String TEXT_531 = ", ";
  protected final String TEXT_532 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_533 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_534 = ", new";
  protected final String TEXT_535 = ", new";
  protected final String TEXT_536 = ");";
  protected final String TEXT_537 = NL + "\t\t";
  protected final String TEXT_538 = " ";
  protected final String TEXT_539 = " = (";
  protected final String TEXT_540 = ")eVirtualGet(";
  protected final String TEXT_541 = ");";
  protected final String TEXT_542 = NL + "\t\tif (new";
  protected final String TEXT_543 = " != ";
  protected final String TEXT_544 = ")" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (";
  protected final String TEXT_545 = " != null)";
  protected final String TEXT_546 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_547 = ", this, OPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_548 = ", null, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_549 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_550 = ", this, OPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_551 = ", null, changeContext);";
  protected final String TEXT_552 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_553 = ", this, ";
  protected final String TEXT_554 = ", ";
  protected final String TEXT_555 = ".class, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_556 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_557 = ", this, ";
  protected final String TEXT_558 = ", ";
  protected final String TEXT_559 = ".class, changeContext);";
  protected final String TEXT_560 = NL + "\t\t\tchangeContext = basicSet";
  protected final String TEXT_561 = "(";
  protected final String TEXT_562 = "new";
  protected final String TEXT_563 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_564 = NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_565 = NL + "\t\t\tboolean old";
  protected final String TEXT_566 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_567 = ");";
  protected final String TEXT_568 = NL + "\t\t\tboolean old";
  protected final String TEXT_569 = "_set_ = (";
  protected final String TEXT_570 = " & ";
  protected final String TEXT_571 = "_ESETFLAG) != 0;";
  protected final String TEXT_572 = NL + "\t\t\t";
  protected final String TEXT_573 = " |= ";
  protected final String TEXT_574 = "_ESETFLAG;";
  protected final String TEXT_575 = NL + "\t\t\tboolean old";
  protected final String TEXT_576 = "_set_ = ";
  protected final String TEXT_577 = "_set_;";
  protected final String TEXT_578 = NL + "\t\t\t";
  protected final String TEXT_579 = "_set_ = true;";
  protected final String TEXT_580 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_581 = ", new";
  protected final String TEXT_582 = ", new";
  protected final String TEXT_583 = ", !old";
  protected final String TEXT_584 = "_set_);";
  protected final String TEXT_585 = NL + "    \t}";
  protected final String TEXT_586 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_587 = ", new";
  protected final String TEXT_588 = ", new";
  protected final String TEXT_589 = ");";
  protected final String TEXT_590 = NL + "\t\t";
  protected final String TEXT_591 = " old";
  protected final String TEXT_592 = " = (";
  protected final String TEXT_593 = " & ";
  protected final String TEXT_594 = "_EFLAG) != 0;";
  protected final String TEXT_595 = NL + "\t\tif (new";
  protected final String TEXT_596 = ") ";
  protected final String TEXT_597 = " |= ";
  protected final String TEXT_598 = "_EFLAG; else ";
  protected final String TEXT_599 = " &= ~";
  protected final String TEXT_600 = "_EFLAG;";
  protected final String TEXT_601 = NL + "\t\t";
  protected final String TEXT_602 = " old";
  protected final String TEXT_603 = " = ";
  protected final String TEXT_604 = ";";
  protected final String TEXT_605 = NL + "\t\t";
  protected final String TEXT_606 = " ";
  protected final String TEXT_607 = " = new";
  protected final String TEXT_608 = " == null ? ";
  protected final String TEXT_609 = "_DEFAULT_ : new";
  protected final String TEXT_610 = ";";
  protected final String TEXT_611 = NL + "\t\t";
  protected final String TEXT_612 = " = new";
  protected final String TEXT_613 = " == null ? ";
  protected final String TEXT_614 = "_DEFAULT_ : new";
  protected final String TEXT_615 = ";";
  protected final String TEXT_616 = NL + "\t\t";
  protected final String TEXT_617 = " ";
  protected final String TEXT_618 = " = ";
  protected final String TEXT_619 = "new";
  protected final String TEXT_620 = ";";
  protected final String TEXT_621 = NL + "\t\t";
  protected final String TEXT_622 = " = ";
  protected final String TEXT_623 = "new";
  protected final String TEXT_624 = ";";
  protected final String TEXT_625 = NL + "\t\tObject old";
  protected final String TEXT_626 = " = eVirtualSet(";
  protected final String TEXT_627 = ", ";
  protected final String TEXT_628 = ");";
  protected final String TEXT_629 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_630 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_631 = NL + "\t\tboolean old";
  protected final String TEXT_632 = "_set_ = (";
  protected final String TEXT_633 = " & ";
  protected final String TEXT_634 = "_ESETFLAG) != 0;";
  protected final String TEXT_635 = NL + "\t\t";
  protected final String TEXT_636 = " |= ";
  protected final String TEXT_637 = "_ESETFLAG;";
  protected final String TEXT_638 = NL + "\t\tboolean old";
  protected final String TEXT_639 = "_set_ = ";
  protected final String TEXT_640 = "_set_;";
  protected final String TEXT_641 = NL + "\t\t";
  protected final String TEXT_642 = "_set_ = true;";
  protected final String TEXT_643 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_644 = ", ";
  protected final String TEXT_645 = "isSetChange ? ";
  protected final String TEXT_646 = "null";
  protected final String TEXT_647 = "_DEFAULT_";
  protected final String TEXT_648 = " : old";
  protected final String TEXT_649 = "old";
  protected final String TEXT_650 = ", ";
  protected final String TEXT_651 = "new";
  protected final String TEXT_652 = ", ";
  protected final String TEXT_653 = "isSetChange";
  protected final String TEXT_654 = "!old";
  protected final String TEXT_655 = "_set_";
  protected final String TEXT_656 = ");";
  protected final String TEXT_657 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_658 = ", ";
  protected final String TEXT_659 = "old";
  protected final String TEXT_660 = " == EVIRTUAL_NO_VALUE ? ";
  protected final String TEXT_661 = "null";
  protected final String TEXT_662 = "_DEFAULT_";
  protected final String TEXT_663 = " : old";
  protected final String TEXT_664 = "old";
  protected final String TEXT_665 = ", ";
  protected final String TEXT_666 = "new";
  protected final String TEXT_667 = ");";
  protected final String TEXT_668 = NL + "\t\tset(get";
  protected final String TEXT_669 = "(), getType(), INTERNAL_";
  protected final String TEXT_670 = ", ";
  protected final String TEXT_671 = " new ";
  protected final String TEXT_672 = "(";
  protected final String TEXT_673 = "new";
  protected final String TEXT_674 = ")";
  protected final String TEXT_675 = ");";
  protected final String TEXT_676 = NL + "\t\t((";
  protected final String TEXT_677 = ".Internal)get";
  protected final String TEXT_678 = "()).set(";
  protected final String TEXT_679 = ", ";
  protected final String TEXT_680 = "new ";
  protected final String TEXT_681 = "(";
  protected final String TEXT_682 = "new";
  protected final String TEXT_683 = ")";
  protected final String TEXT_684 = ");";
  protected final String TEXT_685 = NL + "\t\t// TODO: implement this method to set the '";
  protected final String TEXT_686 = "' ";
  protected final String TEXT_687 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_688 = NL + "\t}" + NL;
  protected final String TEXT_689 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicUnset";
  protected final String TEXT_690 = "(ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_691 = NL + "\t\tObject old";
  protected final String TEXT_692 = " = eVirtualUnset(";
  protected final String TEXT_693 = ");";
  protected final String TEXT_694 = NL + "\t\t";
  protected final String TEXT_695 = " old";
  protected final String TEXT_696 = " = ";
  protected final String TEXT_697 = ";" + NL + "\t\t";
  protected final String TEXT_698 = " = null;";
  protected final String TEXT_699 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_700 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_701 = NL + "\t\tboolean old";
  protected final String TEXT_702 = "_set_ = (";
  protected final String TEXT_703 = " & ";
  protected final String TEXT_704 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_705 = " &= ~";
  protected final String TEXT_706 = "_ESETFLAG;";
  protected final String TEXT_707 = NL + "\t\tboolean old";
  protected final String TEXT_708 = "_set_ = ";
  protected final String TEXT_709 = "_set_;" + NL + "\t\t";
  protected final String TEXT_710 = "_set_ = false;";
  protected final String TEXT_711 = NL + "\t\tif (isNotifying())" + NL + "\t\t{";
  protected final String TEXT_712 = NL + "\t\t\taddNotification(this, ChangeKind.UNSET, ";
  protected final String TEXT_713 = ", ";
  protected final String TEXT_714 = "isSetChange ? null : old";
  protected final String TEXT_715 = "old";
  protected final String TEXT_716 = ", null, ";
  protected final String TEXT_717 = "isSetChange";
  protected final String TEXT_718 = "!old";
  protected final String TEXT_719 = "_set_";
  protected final String TEXT_720 = ", changeContext);";
  protected final String TEXT_721 = NL + "\t\t\taddNotification(this, ChangeKind.UNSET, ";
  protected final String TEXT_722 = ", ";
  protected final String TEXT_723 = "old";
  protected final String TEXT_724 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_725 = "old";
  protected final String TEXT_726 = ", null, changeContext);";
  protected final String TEXT_727 = NL + "\t\t}" + NL + "\t\treturn changeContext;";
  protected final String TEXT_728 = NL + "\t\t// TODO: implement this method to unset the contained '";
  protected final String TEXT_729 = "' ";
  protected final String TEXT_730 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_731 = NL + "\t}" + NL;
  protected final String TEXT_732 = NL + "\t/**" + NL + "\t * Unsets the value of the '{@link ";
  protected final String TEXT_733 = "#";
  protected final String TEXT_734 = " <em>";
  protected final String TEXT_735 = "</em>}' ";
  protected final String TEXT_736 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_737 = NL + "\t * @see #isSet";
  protected final String TEXT_738 = "()";
  protected final String TEXT_739 = NL + "\t * @see #";
  protected final String TEXT_740 = "()";
  protected final String TEXT_741 = NL + "\t * @see #set";
  protected final String TEXT_742 = "(";
  protected final String TEXT_743 = ")";
  protected final String TEXT_744 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_745 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_746 = NL + "\tvoid unset";
  protected final String TEXT_747 = "();" + NL;
  protected final String TEXT_748 = NL + "\tpublic void unset";
  protected final String TEXT_749 = "()" + NL + "\t{";
  protected final String TEXT_750 = NL + "\t\tunset(";
  protected final String TEXT_751 = ");";
  protected final String TEXT_752 = NL + "\t\t((";
  protected final String TEXT_753 = ".Unsettable)get";
  protected final String TEXT_754 = "()).unset();";
  protected final String TEXT_755 = NL + "\t\t";
  protected final String TEXT_756 = " ";
  protected final String TEXT_757 = " = (";
  protected final String TEXT_758 = ")eVirtualGet(";
  protected final String TEXT_759 = ");";
  protected final String TEXT_760 = NL + "\t\tif (";
  protected final String TEXT_761 = " != null)" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;";
  protected final String TEXT_762 = NL + "\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_763 = ", this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_764 = ", null, changeContext);";
  protected final String TEXT_765 = NL + "\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_766 = ", this, ";
  protected final String TEXT_767 = ", ";
  protected final String TEXT_768 = ".class, changeContext);";
  protected final String TEXT_769 = NL + "\t\t\tchangeContext = basicUnset";
  protected final String TEXT_770 = "(changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}" + NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_771 = NL + "\t\t\tboolean old";
  protected final String TEXT_772 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_773 = ");";
  protected final String TEXT_774 = NL + "\t\t\tboolean old";
  protected final String TEXT_775 = "_set_ = (";
  protected final String TEXT_776 = " & ";
  protected final String TEXT_777 = "_ESETFLAG) != 0;";
  protected final String TEXT_778 = NL + "\t\t\t";
  protected final String TEXT_779 = " &= ~";
  protected final String TEXT_780 = "_ESETFLAG;";
  protected final String TEXT_781 = NL + "\t\t\tboolean old";
  protected final String TEXT_782 = "_set_ = ";
  protected final String TEXT_783 = "_set_;";
  protected final String TEXT_784 = NL + "\t\t\t";
  protected final String TEXT_785 = "_set_ = false;";
  protected final String TEXT_786 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_787 = ", null, null, old";
  protected final String TEXT_788 = "_set_);";
  protected final String TEXT_789 = NL + "    \t}";
  protected final String TEXT_790 = NL + "\t\t";
  protected final String TEXT_791 = " old";
  protected final String TEXT_792 = " = (";
  protected final String TEXT_793 = " & ";
  protected final String TEXT_794 = "_EFLAG) != 0;";
  protected final String TEXT_795 = NL + "\t\tObject old";
  protected final String TEXT_796 = " = eVirtualUnset(";
  protected final String TEXT_797 = ");";
  protected final String TEXT_798 = NL + "\t\t";
  protected final String TEXT_799 = " old";
  protected final String TEXT_800 = " = ";
  protected final String TEXT_801 = ";";
  protected final String TEXT_802 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_803 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_804 = NL + "\t\tboolean old";
  protected final String TEXT_805 = "_set_ = (";
  protected final String TEXT_806 = " & ";
  protected final String TEXT_807 = "_ESETFLAG) != 0;";
  protected final String TEXT_808 = NL + "\t\tboolean old";
  protected final String TEXT_809 = "_set_ = ";
  protected final String TEXT_810 = "_set_;";
  protected final String TEXT_811 = NL + "\t\t";
  protected final String TEXT_812 = " = null;";
  protected final String TEXT_813 = NL + "\t\t";
  protected final String TEXT_814 = " &= ~";
  protected final String TEXT_815 = "_ESETFLAG;";
  protected final String TEXT_816 = NL + "\t\t";
  protected final String TEXT_817 = "_set_ = false;";
  protected final String TEXT_818 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_819 = ", ";
  protected final String TEXT_820 = "isSetChange ? old";
  protected final String TEXT_821 = " : null";
  protected final String TEXT_822 = "old";
  protected final String TEXT_823 = ", null, ";
  protected final String TEXT_824 = "isSetChange";
  protected final String TEXT_825 = "old";
  protected final String TEXT_826 = "_set_";
  protected final String TEXT_827 = ");";
  protected final String TEXT_828 = NL + "\t\tif (";
  protected final String TEXT_829 = "_DEFAULT_) ";
  protected final String TEXT_830 = " |= ";
  protected final String TEXT_831 = "_EFLAG; else ";
  protected final String TEXT_832 = " &= ~";
  protected final String TEXT_833 = "_EFLAG;";
  protected final String TEXT_834 = NL + "\t\t";
  protected final String TEXT_835 = " = ";
  protected final String TEXT_836 = "_DEFAULT_;";
  protected final String TEXT_837 = NL + "\t\t";
  protected final String TEXT_838 = " &= ~";
  protected final String TEXT_839 = "_ESETFLAG;";
  protected final String TEXT_840 = NL + "\t\t";
  protected final String TEXT_841 = "_set_ = false;";
  protected final String TEXT_842 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_843 = ", ";
  protected final String TEXT_844 = "isSetChange ? old";
  protected final String TEXT_845 = " : ";
  protected final String TEXT_846 = "_DEFAULT_";
  protected final String TEXT_847 = "old";
  protected final String TEXT_848 = ", ";
  protected final String TEXT_849 = "_DEFAULT_, ";
  protected final String TEXT_850 = "isSetChange";
  protected final String TEXT_851 = "old";
  protected final String TEXT_852 = "_set_";
  protected final String TEXT_853 = ");";
  protected final String TEXT_854 = NL + "        unset(get";
  protected final String TEXT_855 = "(), getType(), ";
  protected final String TEXT_856 = ");";
  protected final String TEXT_857 = NL + "        unset";
  protected final String TEXT_858 = "(get";
  protected final String TEXT_859 = "());";
  protected final String TEXT_860 = NL + "\t\t// TODO: implement this method to unset the '";
  protected final String TEXT_861 = "' ";
  protected final String TEXT_862 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_863 = NL + "\t}" + NL;
  protected final String TEXT_864 = NL + "\t/**" + NL + "\t * Returns whether the value of the '{@link ";
  protected final String TEXT_865 = "#";
  protected final String TEXT_866 = " <em>";
  protected final String TEXT_867 = "</em>}' ";
  protected final String TEXT_868 = " is set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return whether the value of the '<em>";
  protected final String TEXT_869 = "</em>' ";
  protected final String TEXT_870 = " is set.";
  protected final String TEXT_871 = NL + "\t * @see #unset";
  protected final String TEXT_872 = "()";
  protected final String TEXT_873 = NL + "\t * @see #";
  protected final String TEXT_874 = "()";
  protected final String TEXT_875 = NL + "\t * @see #set";
  protected final String TEXT_876 = "(";
  protected final String TEXT_877 = ")";
  protected final String TEXT_878 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_879 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_880 = NL + "\tboolean isSet";
  protected final String TEXT_881 = "();" + NL;
  protected final String TEXT_882 = NL + "\tpublic boolean isSet";
  protected final String TEXT_883 = "()" + NL + "\t{";
  protected final String TEXT_884 = NL + "\t\treturn isSet(";
  protected final String TEXT_885 = ");";
  protected final String TEXT_886 = NL + "\t\t";
  protected final String TEXT_887 = " ";
  protected final String TEXT_888 = " = (";
  protected final String TEXT_889 = ")eVirtualGet(";
  protected final String TEXT_890 = ");";
  protected final String TEXT_891 = NL + "\t\treturn ";
  protected final String TEXT_892 = " != null && ((";
  protected final String TEXT_893 = ".Unsettable)";
  protected final String TEXT_894 = ").isSet();";
  protected final String TEXT_895 = NL + "\t\treturn eVirtualIsSet(";
  protected final String TEXT_896 = ");";
  protected final String TEXT_897 = NL + "\t\treturn (";
  protected final String TEXT_898 = " & ";
  protected final String TEXT_899 = "_ESETFLAG) != 0;";
  protected final String TEXT_900 = NL + "\t\treturn ";
  protected final String TEXT_901 = "_set_;";
  protected final String TEXT_902 = NL + "        return isSet(get";
  protected final String TEXT_903 = "(), getType(), ";
  protected final String TEXT_904 = ");";
  protected final String TEXT_905 = NL + "\t\treturn !((";
  protected final String TEXT_906 = ".Internal)get";
  protected final String TEXT_907 = "()).isEmpty(";
  protected final String TEXT_908 = ");";
  protected final String TEXT_909 = NL + "\t\t// TODO: implement this method to return whether the '";
  protected final String TEXT_910 = "' ";
  protected final String TEXT_911 = " is set" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_912 = NL + "\t}" + NL;
  protected final String TEXT_913 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_914 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_915 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_916 = NL + "\t * @model ";
  protected final String TEXT_917 = NL + "\t *        ";
  protected final String TEXT_918 = NL + "\t * @model";
  protected final String TEXT_919 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_920 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_921 = NL + "\t";
  protected final String TEXT_922 = " ";
  protected final String TEXT_923 = "(";
  protected final String TEXT_924 = ")";
  protected final String TEXT_925 = ";" + NL;
  protected final String TEXT_926 = NL + "\tpublic ";
  protected final String TEXT_927 = " ";
  protected final String TEXT_928 = "(";
  protected final String TEXT_929 = ")";
  protected final String TEXT_930 = NL + "\t{";
  protected final String TEXT_931 = NL + "\t\t";
  protected final String TEXT_932 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_933 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_934 = ".add" + NL + "\t\t\t\t\t(new ";
  protected final String TEXT_935 = NL + "\t\t\t\t\t\t(";
  protected final String TEXT_936 = ".ERROR," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_937 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_938 = ".";
  protected final String TEXT_939 = "," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_940 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
  protected final String TEXT_941 = "\", ";
  protected final String TEXT_942 = ".getObjectLabel(this, ";
  protected final String TEXT_943 = ") }),";
  protected final String TEXT_944 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
  protected final String TEXT_945 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_946 = NL + "\t}" + NL;
  protected final String TEXT_947 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eInverseAdd(";
  protected final String TEXT_948 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_949 = NL + "\t\t\tcase ";
  protected final String TEXT_950 = ":";
  protected final String TEXT_951 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_952 = ")((";
  protected final String TEXT_953 = ".InternalMapView)";
  protected final String TEXT_954 = "()).eMap()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_955 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_956 = ")";
  protected final String TEXT_957 = "()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_958 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
  protected final String TEXT_959 = ", changeContext);";
  protected final String TEXT_960 = NL + "\t\t\t\t";
  protected final String TEXT_961 = " ";
  protected final String TEXT_962 = " = (";
  protected final String TEXT_963 = ")eVirtualGet(";
  protected final String TEXT_964 = ");";
  protected final String TEXT_965 = NL + "\t\t\t\tif (";
  protected final String TEXT_966 = " != null)";
  protected final String TEXT_967 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_968 = ")";
  protected final String TEXT_969 = ").inverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_970 = ", null, changeContext);";
  protected final String TEXT_971 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_972 = ")";
  protected final String TEXT_973 = ").inverseRemove(this, ";
  protected final String TEXT_974 = ", ";
  protected final String TEXT_975 = ".class, changeContext);";
  protected final String TEXT_976 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_977 = "((";
  protected final String TEXT_978 = ")otherEnd, changeContext);";
  protected final String TEXT_979 = NL + "\t\t}";
  protected final String TEXT_980 = NL + "\t\treturn super.eInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_981 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_982 = NL + "\t}" + NL;
  protected final String TEXT_983 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext inverseRemove(";
  protected final String TEXT_984 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_985 = NL + "\t\t\tcase ";
  protected final String TEXT_986 = ":";
  protected final String TEXT_987 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_988 = ")((";
  protected final String TEXT_989 = ".InternalMapView)";
  protected final String TEXT_990 = "()).eMap()).basicRemove(otherEnd, changeContext);";
  protected final String TEXT_991 = NL + "\t\t\t\treturn removeFrom";
  protected final String TEXT_992 = "(";
  protected final String TEXT_993 = "(), otherEnd, changeContext);";
  protected final String TEXT_994 = NL + "\t\t\t\treturn removeFromList(";
  protected final String TEXT_995 = "(), otherEnd, changeContext);";
  protected final String TEXT_996 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
  protected final String TEXT_997 = ", changeContext);";
  protected final String TEXT_998 = NL + "\t\t\t\treturn basicUnset";
  protected final String TEXT_999 = "(changeContext);";
  protected final String TEXT_1000 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1001 = "(null, changeContext);";
  protected final String TEXT_1002 = NL + "\t\t}";
  protected final String TEXT_1003 = NL + "\t\treturn super.inverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_1004 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_1005 = NL + "\t}" + NL;
  protected final String TEXT_1006 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eBasicRemoveFromContainerFeature(ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID)" + NL + "\t\t{";
  protected final String TEXT_1007 = NL + "\t\t\tcase ";
  protected final String TEXT_1008 = ":" + NL + "\t\t\t\treturn eInternalContainer().inverseRemove(this, ";
  protected final String TEXT_1009 = ", ";
  protected final String TEXT_1010 = ".class, changeContext);";
  protected final String TEXT_1011 = NL + "\t\t}";
  protected final String TEXT_1012 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(changeContext);";
  protected final String TEXT_1013 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(changeContext);";
  protected final String TEXT_1014 = NL + "\t}" + NL;
  protected final String TEXT_1015 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object get(int propertyIndex, boolean resolve)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1016 = NL + "\t\t\tcase ";
  protected final String TEXT_1017 = ":";
  protected final String TEXT_1018 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1019 = "() ? Boolean.TRUE : Boolean.FALSE;";
  protected final String TEXT_1020 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_1021 = "(";
  protected final String TEXT_1022 = "());";
  protected final String TEXT_1023 = NL + "\t\t\t\tif (resolve) return ";
  protected final String TEXT_1024 = "();" + NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1025 = "();";
  protected final String TEXT_1026 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1027 = ".InternalMapView)";
  protected final String TEXT_1028 = "()).eMap();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1029 = "();";
  protected final String TEXT_1030 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1031 = "();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1032 = "().map();";
  protected final String TEXT_1033 = NL + "\t\t\t\t// XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view" + NL + "\t\t\t\t//if (coreType) " + NL + "\t\t\t\treturn ";
  protected final String TEXT_1034 = "();";
  protected final String TEXT_1035 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1036 = "();" + NL + "\t\t\t\treturn ((";
  protected final String TEXT_1037 = ".Internal)";
  protected final String TEXT_1038 = "()).getWrapper();";
  protected final String TEXT_1039 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1040 = "();";
  protected final String TEXT_1041 = NL + "\t\t}";
  protected final String TEXT_1042 = NL + "\t\treturn super.get(propertyIndex, resolve);";
  protected final String TEXT_1043 = NL + "\t\treturn eDynamicGet(propertyIndex, resolve, coreType);";
  protected final String TEXT_1044 = NL + "\t}" + NL;
  protected final String TEXT_1045 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void set(int propertyIndex, Object newValue)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1046 = NL + "\t\t\tcase ";
  protected final String TEXT_1047 = ":";
  protected final String TEXT_1048 = NL + "      \tset";
  protected final String TEXT_1049 = "(";
  protected final String TEXT_1050 = "(), newValue);";
  protected final String TEXT_1051 = NL + "\t\t\t\t((";
  protected final String TEXT_1052 = ".Internal)";
  protected final String TEXT_1053 = "()).set(newValue);";
  protected final String TEXT_1054 = NL + "\t\t\t\t((";
  protected final String TEXT_1055 = ".Setting)((";
  protected final String TEXT_1056 = ".InternalMapView)";
  protected final String TEXT_1057 = "()).eMap()).set(newValue);";
  protected final String TEXT_1058 = NL + "\t\t\t\t((";
  protected final String TEXT_1059 = ".Setting)";
  protected final String TEXT_1060 = "()).set(newValue);";
  protected final String TEXT_1061 = NL + "\t\t\t\t";
  protected final String TEXT_1062 = "().clear();" + NL + "\t\t\t\t";
  protected final String TEXT_1063 = "().addAll((";
  protected final String TEXT_1064 = ")newValue);";
  protected final String TEXT_1065 = NL + "\t\t\t\tset";
  protected final String TEXT_1066 = "(((";
  protected final String TEXT_1067 = ")newValue).";
  protected final String TEXT_1068 = "());";
  protected final String TEXT_1069 = NL + "\t\t\t\tset";
  protected final String TEXT_1070 = "((";
  protected final String TEXT_1071 = ")newValue);";
  protected final String TEXT_1072 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1073 = NL + "\t\t}";
  protected final String TEXT_1074 = NL + "\t\tsuper.set(propertyIndex, newValue);";
  protected final String TEXT_1075 = NL + "\t\teDynamicSet(propertyIndex, newValue);";
  protected final String TEXT_1076 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void unset(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1077 = NL + "\t\t\tcase ";
  protected final String TEXT_1078 = ":";
  protected final String TEXT_1079 = NL + "\t\t\t\tunset";
  protected final String TEXT_1080 = "(";
  protected final String TEXT_1081 = "());";
  protected final String TEXT_1082 = NL + "\t\t\t\t";
  protected final String TEXT_1083 = "().clear();";
  protected final String TEXT_1084 = NL + "\t\t\t\tunset";
  protected final String TEXT_1085 = "();";
  protected final String TEXT_1086 = NL + "\t\t\t\tset";
  protected final String TEXT_1087 = "((";
  protected final String TEXT_1088 = ")null);";
  protected final String TEXT_1089 = NL + "\t\t\t\tset";
  protected final String TEXT_1090 = "(";
  protected final String TEXT_1091 = "_DEFAULT_);";
  protected final String TEXT_1092 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1093 = NL + "\t\t}";
  protected final String TEXT_1094 = NL + "\t\tsuper.unset(propertyIndex);";
  protected final String TEXT_1095 = NL + "\t\teDynamicUnset(propertyIndex);";
  protected final String TEXT_1096 = NL + "\t}" + NL;
  protected final String TEXT_1097 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSet(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1098 = NL + "\t\t\tcase ";
  protected final String TEXT_1099 = ":";
  protected final String TEXT_1100 = NL + "\t\t\t\treturn !is";
  protected final String TEXT_1101 = "Empty(";
  protected final String TEXT_1102 = "());";
  protected final String TEXT_1103 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1104 = " != null && !is";
  protected final String TEXT_1105 = "Empty(";
  protected final String TEXT_1106 = "());";
  protected final String TEXT_1107 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1108 = " != null && !";
  protected final String TEXT_1109 = ".isEmpty();";
  protected final String TEXT_1110 = NL + "\t\t\t\t";
  protected final String TEXT_1111 = " ";
  protected final String TEXT_1112 = " = (";
  protected final String TEXT_1113 = ")eVirtualGet(";
  protected final String TEXT_1114 = ");" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1115 = " != null && !";
  protected final String TEXT_1116 = ".isEmpty();";
  protected final String TEXT_1117 = NL + "\t\t\t\treturn !";
  protected final String TEXT_1118 = "().isEmpty();";
  protected final String TEXT_1119 = NL + "\t\t\t\treturn isSet";
  protected final String TEXT_1120 = "();";
  protected final String TEXT_1121 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1122 = " != null;";
  protected final String TEXT_1123 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1124 = ") != null;";
  protected final String TEXT_1125 = NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1126 = "() != null;";
  protected final String TEXT_1127 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1128 = " != null;";
  protected final String TEXT_1129 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1130 = ") != null;";
  protected final String TEXT_1131 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1132 = "() != null;";
  protected final String TEXT_1133 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1134 = " & ";
  protected final String TEXT_1135 = "_EFLAG) != 0) != ";
  protected final String TEXT_1136 = "_DEFAULT_;";
  protected final String TEXT_1137 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1138 = " != ";
  protected final String TEXT_1139 = "_DEFAULT_;";
  protected final String TEXT_1140 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1141 = ", ";
  protected final String TEXT_1142 = "_DEFAULT_) != ";
  protected final String TEXT_1143 = "_DEFAULT_;";
  protected final String TEXT_1144 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1145 = "() != ";
  protected final String TEXT_1146 = "_DEFAULT_;";
  protected final String TEXT_1147 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1148 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1149 = " != null : !";
  protected final String TEXT_1150 = "_DEFAULT_.equals(";
  protected final String TEXT_1151 = ");";
  protected final String TEXT_1152 = NL + "\t\t\t\t";
  protected final String TEXT_1153 = " ";
  protected final String TEXT_1154 = " = (";
  protected final String TEXT_1155 = ")eVirtualGet(";
  protected final String TEXT_1156 = ", ";
  protected final String TEXT_1157 = "_DEFAULT_);" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1158 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1159 = " != null : !";
  protected final String TEXT_1160 = "_DEFAULT_.equals(";
  protected final String TEXT_1161 = ");";
  protected final String TEXT_1162 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1163 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1164 = "() != null : !";
  protected final String TEXT_1165 = "_DEFAULT_.equals(";
  protected final String TEXT_1166 = "());";
  protected final String TEXT_1167 = NL + "\t\t}";
  protected final String TEXT_1168 = NL + "\t\treturn super.isSet(propertyIndex);";
  protected final String TEXT_1169 = NL + "\t\treturn eDynamicIsSet(propertyIndex);";
  protected final String TEXT_1170 = NL + "\t}" + NL;
  protected final String TEXT_1171 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1172 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1173 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1174 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1175 = ": return ";
  protected final String TEXT_1176 = ";";
  protected final String TEXT_1177 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1178 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1179 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1180 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1181 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1182 = ": return ";
  protected final String TEXT_1183 = ";";
  protected final String TEXT_1184 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1185 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);" + NL + "\t}" + NL;
  protected final String TEXT_1186 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_1187 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualValues(Object[] newValues)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1188 = " = newValues;" + NL + "\t}" + NL;
  protected final String TEXT_1189 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1190 = NL + "\t\t\tcase ";
  protected final String TEXT_1191 = " :" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1192 = ";";
  protected final String TEXT_1193 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualIndexBits(int offset, int newIndexBits)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1194 = NL + "\t\t\tcase ";
  protected final String TEXT_1195 = " :" + NL + "\t\t\t\t";
  protected final String TEXT_1196 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_1197 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_1198 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String toString()" + NL + "\t{" + NL + "\t\tif (isProxy(this)) return super.toString();" + NL + "" + NL + "\t\tStringBuffer result = new StringBuffer(super.toString());";
  protected final String TEXT_1199 = NL + "\t\tresult.append(\" (";
  protected final String TEXT_1200 = ": \");";
  protected final String TEXT_1201 = NL + "\t\tresult.append(\", ";
  protected final String TEXT_1202 = ": \");";
  protected final String TEXT_1203 = NL + "\t\tif (eVirtualIsSet(";
  protected final String TEXT_1204 = ")) result.append(eVirtualGet(";
  protected final String TEXT_1205 = ")); else result.append(\"<unset>\");";
  protected final String TEXT_1206 = NL + "\t\tif (";
  protected final String TEXT_1207 = "(";
  protected final String TEXT_1208 = " & ";
  protected final String TEXT_1209 = "_ESETFLAG) != 0";
  protected final String TEXT_1210 = "_set_";
  protected final String TEXT_1211 = ") result.append((";
  protected final String TEXT_1212 = " & ";
  protected final String TEXT_1213 = "_EFLAG) != 0); else result.append(\"<unset>\");";
  protected final String TEXT_1214 = NL + "\t\tif (";
  protected final String TEXT_1215 = "(";
  protected final String TEXT_1216 = " & ";
  protected final String TEXT_1217 = "_ESETFLAG) != 0";
  protected final String TEXT_1218 = "_set_";
  protected final String TEXT_1219 = ") result.append(";
  protected final String TEXT_1220 = "); else result.append(\"<unset>\");";
  protected final String TEXT_1221 = NL + "\t\tresult.append(eVirtualGet(";
  protected final String TEXT_1222 = ", ";
  protected final String TEXT_1223 = "_DEFAULT_";
  protected final String TEXT_1224 = "));";
  protected final String TEXT_1225 = NL + "\t\tresult.append((";
  protected final String TEXT_1226 = " & ";
  protected final String TEXT_1227 = "_EFLAG) != 0);";
  protected final String TEXT_1228 = NL + "\t\tresult.append(";
  protected final String TEXT_1229 = ");";
  protected final String TEXT_1230 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}" + NL;
  protected final String TEXT_1231 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)" + NL + "\t\t{" + NL + "\t\t\tObject theKey = getKey();" + NL + "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL + "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic Object getKey()" + NL + "\t{" + NL + "  \t";
  protected final String TEXT_1232 = NL + "\t\treturn new ";
  protected final String TEXT_1233 = "(getTypedKey());" + NL + " \t";
  protected final String TEXT_1234 = NL + "\t\treturn getTypedKey();" + NL + "  \t";
  protected final String TEXT_1235 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(Object key)" + NL + "\t{";
  protected final String TEXT_1236 = NL + "\t\tgetTypedKey().addAll((";
  protected final String TEXT_1237 = ")key);";
  protected final String TEXT_1238 = NL + "\t\tsetTypedKey(((";
  protected final String TEXT_1239 = ")key).";
  protected final String TEXT_1240 = "());";
  protected final String TEXT_1241 = NL + "\t\tsetTypedKey((";
  protected final String TEXT_1242 = ")key);";
  protected final String TEXT_1243 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getValue()" + NL + "\t{" + NL + " \t";
  protected final String TEXT_1244 = NL + "\t\treturn new ";
  protected final String TEXT_1245 = "(getTypedValue());" + NL + " \t";
  protected final String TEXT_1246 = NL + "\t\treturn getTypedValue();" + NL + " \t";
  protected final String TEXT_1247 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object setValue(Object value)" + NL + "\t{" + NL + "\t\tObject oldValue = getValue();" + NL + "  \t";
  protected final String TEXT_1248 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll((";
  protected final String TEXT_1249 = ")value);" + NL + "  \t";
  protected final String TEXT_1250 = NL + "\t\tsetTypedValue(((";
  protected final String TEXT_1251 = ")value).";
  protected final String TEXT_1252 = "());" + NL + "  \t";
  protected final String TEXT_1253 = NL + "\t\tsetTypedValue((";
  protected final String TEXT_1254 = ")value);" + NL + "  \t";
  protected final String TEXT_1255 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1256 = " getEMap()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1257 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
  protected final String TEXT_1258 = ")container.get(eContainmentFeature());" + NL + "\t}";
  protected final String TEXT_1259 = NL + "} //";
  protected final String TEXT_1260 = NL;

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
    if (!genFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_21);
    }
    }
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_26);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_29);
    }}
    if (genClass.needsRootExtendsInterfaceExtendsTag()) { // does it need an @extends tag 
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
    }
    stringBuffer.append(TEXT_31);
    } else {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_33);
    if (!genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_34);
    for (Iterator i=genClass.getImplementedGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genClass.getQualifiedClassName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_41);
    if (genClass.isAbstract()) {
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(genClass.getClassExtends());
    stringBuffer.append(genClass.getClassImplements());
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genClass.getInterfaceName());
    stringBuffer.append(genClass.getInterfaceExtends());
    }
    stringBuffer.append(TEXT_45);
    if (genModel.getCopyrightText() != null) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genModel.getCopyrightText());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_49);
    }
    if (isImplementation && genModel.getDriverNumber() != null) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genModel.getDriverNumber());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_53);
    }
    if (isImplementation && genClass.isJavaIOSerializable()) {
    stringBuffer.append(TEXT_54);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_56);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) {
    for (Iterator i = eVirtualIndexBitFields.iterator(); i.hasNext();) { String eVirtualIndexBitField = (String)i.next();
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eVirtualIndexBitField);
    stringBuffer.append(TEXT_58);
    }
    }
    }
    }
    if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled() && genModel.getBooleanFlagsReservedBits() == -1) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genModel.getBooleanFlagsField());
    stringBuffer.append(TEXT_60);
    }
    if (isImplementation && !genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_61);
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
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(featureValue);
    stringBuffer.append(TEXT_64);
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
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(featureValue);
    stringBuffer.append(TEXT_67);
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
    stringBuffer.append(TEXT_68);
    stringBuffer.append(featureCount);
    stringBuffer.append(TEXT_69);
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
    stringBuffer.append(TEXT_70);
    stringBuffer.append(featureCount);
    stringBuffer.append(TEXT_71);
    for (Iterator f=genClass.getAllGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next();
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_74);
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
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(featureValue);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
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
    stringBuffer.append(TEXT_79);
    stringBuffer.append(featureCount);
    stringBuffer.append(TEXT_80);
    for (Iterator f=genClass.getAllGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next();
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    for (Iterator i=genClass.getDeclaredFieldGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genFeature.isListType() || genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genModel.getImportedName(genFeature.getType()));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_91);
    }
    if (genModel.isArrayAccessors() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_98);
    }
    } else {
    if (!genFeature.isVolatile() || !genModel.isReflectiveDelegation() && (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable())) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genFeature.getStaticDefaultValue());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genModel.getNonNLS(genFeature.getStaticDefaultValue()));
    stringBuffer.append(TEXT_107);
    }
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    if (genClass.getFlagIndex(genFeature) > 31 && genClass.getFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append("<< " + genClass.getFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_116);
    } else {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_124);
    }
    }
    }
    if (genClass.isESetField(genFeature)) {
    if (genClass.isESetFlag(genFeature)) {
    if (genClass.getESetFlagIndex(genFeature) > 31 && genClass.getESetFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_126);
    }
    stringBuffer.append(TEXT_127);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append("<< " + genClass.getESetFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_131);
    } else {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_135);
    }
    }
    }
    //Class/declaredFieldGenFeature.override.javajetinc
    }
    if (isImplementation) { // create constructor 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_137);
    for (Iterator i=genClass.getFlagGenFeatures("true").iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_138);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_140);
    }
    if (SDOGenUtil.hasChangeSummaryProperty(genClass)) {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(SDOGenUtil.getChangeSummaryProperty(genClass));
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genPackage.getImportedFactoryClassName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genPackage.getImportedFactoryInterfaceName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_147);
    }
    /*
     * Output getter and setter interfaces / impls
     */
    
    for (Iterator i=(isImplementation ? genClass.getImplementedGenFeatures() : genClass.getDeclaredGenFeatures()).iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_148);
    if (!isImplementation) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_151);
    } else {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_154);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_159);
    } else {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_168);
    }
    stringBuffer.append(TEXT_169);
    if (!isImplementation) {
    stringBuffer.append(TEXT_170);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_172);
    } else {
    stringBuffer.append(TEXT_173);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    if (!isImplementation) {
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_180);
    } else {
    stringBuffer.append(TEXT_181);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_182);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_184);
    } else {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_187);
    }
    stringBuffer.append(TEXT_188);
    }
    stringBuffer.append(TEXT_189);
    if (!isImplementation) {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_193);
    } else {
    stringBuffer.append(TEXT_194);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_201);
    }
    stringBuffer.append(TEXT_202);
    if (!isImplementation) {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_205);
    } else {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_209);
    }
    }
    if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_212);
    if (genFeature.isListType()) {
    if (genFeature.isMapType()) { GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature(); GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature(); 
    stringBuffer.append(TEXT_213);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(keyFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_215);
    } else {
    stringBuffer.append(TEXT_216);
    stringBuffer.append(keyFeature.getType());
    stringBuffer.append(TEXT_217);
    }
    stringBuffer.append(TEXT_218);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(valueFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_220);
    } else {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(valueFeature.getType());
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    } else if (!genFeature.isWrappedFeatureMapType() && !(genModel.isSuppressEMFMetaData() && "org.eclipse.emf.ecore.EObject".equals(genFeature.getQualifiedListItemType()))) {
    stringBuffer.append(TEXT_224);
    stringBuffer.append(genFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_225);
    }
    } else if (genFeature.isSetDefaultValue()) {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_227);
    }
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_228);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    stringBuffer.append(TEXT_229);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_230);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(reverseGenFeature.getFormattedName());
    stringBuffer.append(TEXT_233);
    }
    }
    stringBuffer.append(TEXT_234);
    if (!genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_235);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_237);
    }
    stringBuffer.append(TEXT_238);
    if (genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(genFeature.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_240);
    }
    stringBuffer.append(TEXT_241);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_243);
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_244);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_246);
    }
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_248);
    }
    }
    if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_249);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_250);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_251);
    }
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_252);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_254);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_255);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    }
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_257);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_259);
    }}
    stringBuffer.append(TEXT_260);
    } else {
    stringBuffer.append(TEXT_261);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_262);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_264);
    } else {
    stringBuffer.append(TEXT_265);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_267);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_268);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_272);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_273);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_274);
    }
    stringBuffer.append(TEXT_275);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_280);
    }
    stringBuffer.append(TEXT_281);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_282);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_283);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_286);
    } else {
                if (genFeature.getType().equals("commonj.sdo.Sequence")){
    stringBuffer.append(TEXT_287);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_289);
    } else {
    stringBuffer.append(TEXT_290);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_293);
    }}
    stringBuffer.append(TEXT_294);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
    stringBuffer.append(TEXT_295);
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_296);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_297);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_298);
    } else {
    if (genFeature.isResolveProxies()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_299);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_301);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_303);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_304);
    }
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_307);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_308);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_309);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_312);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_315);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_316);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_317);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_318);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_320);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_321);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_323);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_324);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.ChangeContext"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_326);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_328);
    }
    stringBuffer.append(TEXT_329);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_330);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_331);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_333);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_334);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_336);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_337);
    }
    stringBuffer.append(TEXT_338);
    } else if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_339);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_341);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_342);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_344);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    }
    if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_347);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_349);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_350);
    }
    stringBuffer.append(TEXT_351);
    } else if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_352);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_354);
    } else {
    stringBuffer.append(TEXT_355);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_356);
    }
    }
    } else {//volatile
    if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_357);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_358);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_359);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_360);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_361);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_362);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_364);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_365);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_366);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); // AAAA
    if (genFeature.isFeatureMapType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_367);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_368);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_369);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_370);
    } else {
    stringBuffer.append(TEXT_371);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_372);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_373);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_374);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_375);
    }
    } else if (genFeature.isListType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_376);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_377);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_378);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_379);
    } else {
    stringBuffer.append(TEXT_380);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_381);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_382);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_383);
    }
    } else {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_384);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_385);
    }
    stringBuffer.append(TEXT_386);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_387);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_388);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_389);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_390);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_391);
    }
    stringBuffer.append(TEXT_392);
    } else {
    stringBuffer.append(TEXT_393);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_394);
    }
    stringBuffer.append(TEXT_395);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_396);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_397);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_398);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_399);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_400);
    }
    stringBuffer.append(TEXT_401);
    }
    }
    } else {
    stringBuffer.append(TEXT_402);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_403);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_404);
    //Class/getGenFeature.todo.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_405);
    }
    //Class/getGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
    stringBuffer.append(TEXT_406);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_407);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_408);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_410);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_411);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_412);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_413);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_414);
    } else {
    stringBuffer.append(TEXT_415);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_416);
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //BBBB
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_417);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_420);
    } else {
    stringBuffer.append(TEXT_421);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_422);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_423);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_424);
    }
    } else {
    stringBuffer.append(TEXT_425);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_426);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_427);
    //Class/basicGetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_428);
    //Class/basicGetGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_429);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_430);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_431);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_432);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_434);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_436);
    } else {
    stringBuffer.append(TEXT_437);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_438);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_439);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_441);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_442);
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_443);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_444);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_445);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_446);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_448);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_450);
    } else {
    stringBuffer.append(TEXT_451);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_452);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_454);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_455);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_456);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_457);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_458);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_459);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_460);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_461);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_462);
    } else {
    stringBuffer.append(TEXT_463);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_464);
    }
    stringBuffer.append(TEXT_465);
    } else {
    stringBuffer.append(TEXT_466);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_467);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_468);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_469);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_470);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_472);
    }
    stringBuffer.append(TEXT_473);
    }
    stringBuffer.append(TEXT_474);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //CCCC
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_475);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_476);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_477);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_478);
    } else {
    stringBuffer.append(TEXT_479);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_480);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_481);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_482);
    }
    } else {
    stringBuffer.append(TEXT_483);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_484);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_485);
    //Class/basicSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_486);
    //Class/basicSetGenFeature.override.javajetinc
    }
    if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
    if (isInterface) { 
    stringBuffer.append(TEXT_487);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_488);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_489);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_491);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_493);
    if (genFeature.isEnumType()) {
    stringBuffer.append(TEXT_494);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_495);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_496);
    }
    if (!genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_497);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_498);
    }
    }
    stringBuffer.append(TEXT_499);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_500);
    } else {
    stringBuffer.append(TEXT_501);
    }
    if (!isImplementation) { 
    stringBuffer.append(TEXT_502);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_503);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_504);
    } else {
    stringBuffer.append(TEXT_505);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_506);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_507);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_508);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_509);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_510);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_511);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_512);
    }
    stringBuffer.append(TEXT_513);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_514);
    }
    stringBuffer.append(TEXT_515);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_516);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_517);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_519);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(genFeature.getEObjectCast());
    stringBuffer.append(TEXT_521);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_524);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_525);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_527);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_529);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_531);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_532);
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_533);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_534);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_536);
    }
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_537);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_538);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_539);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_541);
    }
    stringBuffer.append(TEXT_542);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_544);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_545);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_546);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_547);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_548);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_551);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_552);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_553);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_555);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_556);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_557);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_558);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_559);
    }
    stringBuffer.append(TEXT_560);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_561);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_562);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_563);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_564);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_565);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_566);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_567);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_568);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_569);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_570);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_571);
    }
    stringBuffer.append(TEXT_572);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_573);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_574);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_575);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_576);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_577);
    }
    stringBuffer.append(TEXT_578);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_579);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_580);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_581);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_582);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_583);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_584);
    }
    stringBuffer.append(TEXT_585);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_586);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_587);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_588);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_589);
    }
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_590);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_591);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_592);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_594);
    }
    stringBuffer.append(TEXT_595);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_596);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_597);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_598);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_600);
    } else {
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_601);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_602);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_603);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_604);
    }
    }
    if (genFeature.isEnumType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_605);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_606);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_607);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_608);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_609);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_610);
    } else {
    stringBuffer.append(TEXT_611);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_612);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_613);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_614);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_615);
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_616);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_617);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_618);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_619);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_620);
    } else {
    stringBuffer.append(TEXT_621);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_622);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_623);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_624);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_625);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_626);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_627);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_628);
    }
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_629);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_630);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_631);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_632);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_633);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_634);
    }
    stringBuffer.append(TEXT_635);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_636);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_637);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_638);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_639);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_640);
    }
    stringBuffer.append(TEXT_641);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_642);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_643);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_644);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_645);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_646);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_647);
    }
    stringBuffer.append(TEXT_648);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_649);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_650);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_651);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_652);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_653);
    } else {
    stringBuffer.append(TEXT_654);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_655);
    }
    stringBuffer.append(TEXT_656);
    }
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_657);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_658);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_659);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_660);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_661);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_662);
    }
    stringBuffer.append(TEXT_663);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_664);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_665);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_666);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_667);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); // DDDD
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_668);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_669);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_670);
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_671);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_672);
    }
    stringBuffer.append(TEXT_673);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_674);
    }
    stringBuffer.append(TEXT_675);
    } else {
    stringBuffer.append(TEXT_676);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_677);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_678);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_679);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_680);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_681);
    }
    stringBuffer.append(TEXT_682);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_683);
    }
    stringBuffer.append(TEXT_684);
    }
    } else {
    stringBuffer.append(TEXT_685);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_686);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_687);
    //Class/setGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_688);
    }
    //Class/setGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
    stringBuffer.append(TEXT_689);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_690);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_691);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_692);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_693);
    } else {
    stringBuffer.append(TEXT_694);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_695);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_696);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_697);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_698);
    }
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_699);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_700);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_701);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_702);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_703);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_704);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_706);
    } else {
    stringBuffer.append(TEXT_707);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_708);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_709);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_710);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_711);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_712);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_713);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_714);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_715);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_716);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_717);
    } else {
    stringBuffer.append(TEXT_718);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_719);
    }
    stringBuffer.append(TEXT_720);
    } else {
    stringBuffer.append(TEXT_721);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_722);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_723);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_724);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_725);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_726);
    }
    stringBuffer.append(TEXT_727);
    }
    } else {
    stringBuffer.append(TEXT_728);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_729);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_730);
    //Class/basicUnsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_731);
    //Class.basicUnsetGenFeature.override.javajetinc
    }
    if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_732);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_733);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_734);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_735);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_736);
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_737);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_738);
    }
    stringBuffer.append(TEXT_739);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_740);
    if (!genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_741);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_742);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_743);
    }
    stringBuffer.append(TEXT_744);
    } else {
    stringBuffer.append(TEXT_745);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_746);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_747);
    } else {
    stringBuffer.append(TEXT_748);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_749);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_750);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_751);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    stringBuffer.append(TEXT_752);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_753);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_754);
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_755);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_756);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_757);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_758);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_759);
    }
    stringBuffer.append(TEXT_760);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_761);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_762);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_763);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_764);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_765);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_766);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_767);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_768);
    }
    stringBuffer.append(TEXT_769);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_770);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_771);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_772);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_773);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_774);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_775);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_776);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_777);
    }
    stringBuffer.append(TEXT_778);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_780);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_781);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_782);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_783);
    }
    stringBuffer.append(TEXT_784);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_785);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_786);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_787);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_788);
    }
    stringBuffer.append(TEXT_789);
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_790);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_791);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_792);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_793);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_794);
    }
    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_795);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_796);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_797);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_798);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_799);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_800);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_801);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_802);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_803);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_804);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_805);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_806);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_807);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_808);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_809);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_810);
    }
    }
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_811);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_812);
    if (!genModel.isVirtualDelegation()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_813);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_815);
    } else {
    stringBuffer.append(TEXT_816);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_817);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_818);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_819);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_820);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_821);
    } else {
    stringBuffer.append(TEXT_822);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_823);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_824);
    } else {
    stringBuffer.append(TEXT_825);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_826);
    }
    stringBuffer.append(TEXT_827);
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_828);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_829);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_830);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_831);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_832);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_833);
    } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_834);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_835);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_836);
    }
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_837);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_838);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_839);
    } else {
    stringBuffer.append(TEXT_840);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_841);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_842);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_843);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_844);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_845);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_846);
    } else {
    stringBuffer.append(TEXT_847);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_848);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_849);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_850);
    } else {
    stringBuffer.append(TEXT_851);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_852);
    }
    stringBuffer.append(TEXT_853);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //EEEE
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_854);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_855);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_856);
    } else {
    stringBuffer.append(TEXT_857);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_858);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_859);
    }
    } else {
    stringBuffer.append(TEXT_860);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_861);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_862);
    //Class/unsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_863);
    }
    //Class/unsetGenFeature.override.javajetinc
    }
    if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_864);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_865);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_866);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_867);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_868);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_869);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_870);
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_871);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_872);
    }
    stringBuffer.append(TEXT_873);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_874);
    if (!genFeature.isListType() && genFeature.isChangeable() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_875);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_876);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_877);
    }
    stringBuffer.append(TEXT_878);
    } else {
    stringBuffer.append(TEXT_879);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_880);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_881);
    } else {
    stringBuffer.append(TEXT_882);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_883);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_884);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_885);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_886);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_887);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_888);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_889);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_890);
    }
    stringBuffer.append(TEXT_891);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_892);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_893);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_894);
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_895);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_896);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_897);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_898);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_899);
    } else {
    stringBuffer.append(TEXT_900);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_901);
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //FFFF
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_902);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_903);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_904);
    } else {
    stringBuffer.append(TEXT_905);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_906);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_907);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_908);
    }
    } else {
    stringBuffer.append(TEXT_909);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_911);
    //Class/isSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_912);
    }
    //Class/isSetGenFeature.override.javajetinc
    }
    //Class/genFeature.override.javajetinc
    }// end output getter and setter interfaces or impls
    for (Iterator i= (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations()).iterator(); i.hasNext();) { GenOperation genOperation = (GenOperation)i.next();
    if (isInterface) {
    stringBuffer.append(TEXT_913);
    if (genOperation.hasDocumentation()) {
    stringBuffer.append(TEXT_914);
    stringBuffer.append(genOperation.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_915);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genOperation.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_916);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_917);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_918);
    }}
    stringBuffer.append(TEXT_919);
    } else {
    stringBuffer.append(TEXT_920);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_921);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_922);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_923);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_924);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_925);
    } else {
    stringBuffer.append(TEXT_926);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_927);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_928);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_929);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_930);
    if (genOperation.hasBody()) {
    stringBuffer.append(TEXT_931);
    stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
    } else if (genOperation.isInvariant()) {GenClass opClass = genOperation.getGenClass(); String diagnostics = ((GenParameter)genOperation.getGenParameters().get(0)).getName(); String context = ((GenParameter)genOperation.getGenParameters().get(1)).getName();
    stringBuffer.append(TEXT_932);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_933);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_934);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
    stringBuffer.append(TEXT_936);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_937);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_938);
    stringBuffer.append(opClass.getOperationID(genOperation));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
    stringBuffer.append(TEXT_940);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_941);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_944);
    } else {
    stringBuffer.append(TEXT_945);
    //Class/implementedGenOperation.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_946);
    }
    //Class/implementedGenOperation.override.javajetinc
    }//for
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
    stringBuffer.append(TEXT_947);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_948);
    for (Iterator i=genClass.getEInverseAddGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_949);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_950);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_951);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_952);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_953);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_954);
    } else {
    stringBuffer.append(TEXT_955);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_957);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_958);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_959);
    } else {
    if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_960);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_961);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_962);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_963);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_964);
    }
    stringBuffer.append(TEXT_965);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_966);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_967);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_969);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_970);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_971);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_973);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_975);
    }
    stringBuffer.append(TEXT_976);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_977);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_978);
    }
    }
    }
    stringBuffer.append(TEXT_979);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_980);
    } else {
    stringBuffer.append(TEXT_981);
    }
    stringBuffer.append(TEXT_982);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
    stringBuffer.append(TEXT_983);
    stringBuffer.append(genModel.getImportedName("java.lang.Object"));
    stringBuffer.append(TEXT_984);
    for (Iterator i=genClass.getEInverseRemoveGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_985);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_986);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_987);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_988);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_989);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_990);
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_991);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_992);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_993);
    } else {
    stringBuffer.append(TEXT_994);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_995);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_996);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_997);
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_998);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_999);
    } else {
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1001);
    }
    }
    }
    stringBuffer.append(TEXT_1002);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1003);
    } else {
    stringBuffer.append(TEXT_1004);
    }
    stringBuffer.append(TEXT_1005);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
    stringBuffer.append(TEXT_1006);
    for (Iterator i=genClass.getEBasicRemoveFromContainerGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1010);
    }
    }
    stringBuffer.append(TEXT_1011);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1012);
    } else {
    stringBuffer.append(TEXT_1013);
    }
    stringBuffer.append(TEXT_1014);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1015);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1017);
    if (genFeature.isPrimitiveType()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1019);
    } else {
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1022);
    }
    } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1025);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1029);
    } else {
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1032);
    }
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1034);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1038);
    } else {
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1040);
    }
    }
    }
    stringBuffer.append(TEXT_1041);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1042);
    } else {
    stringBuffer.append(TEXT_1043);
    }
    stringBuffer.append(TEXT_1044);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
    stringBuffer.append(TEXT_1045);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1047);
    if (genFeature.isListType()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1050);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1053);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1057);
    } else {
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1060);
    }
    } else {
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1064);
    }
    } else if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1068);
    } else {
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1071);
    }
    stringBuffer.append(TEXT_1072);
    }
    }
    stringBuffer.append(TEXT_1073);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1074);
    } else {
    stringBuffer.append(TEXT_1075);
    }
    stringBuffer.append(TEXT_1076);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1078);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1081);
    } else {
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1083);
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1085);
    } else if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1088);
    } else {
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1091);
    }
    stringBuffer.append(TEXT_1092);
    }
    }
    stringBuffer.append(TEXT_1093);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1094);
    } else {
    stringBuffer.append(TEXT_1095);
    }
    stringBuffer.append(TEXT_1096);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1097);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1099);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1102);
    } else {
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1106);
    }
    } else {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1109);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1116);
    } else {
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1118);
    }
    }
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1120);
    } else if (genFeature.isResolveProxies()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1122);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1124);
    } else {
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1126);
    }
    }
    } else if (genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1128);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1130);
    } else {
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1132);
    }
    }
    } else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1136);
    } else {
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1139);
    }
    } else {
    if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1143);
    } else {
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1146);
    }
    }
    } else {//datatype
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1151);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1161);
    } else {
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1166);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1167);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1168);
    } else {
    stringBuffer.append(TEXT_1169);
    }
    stringBuffer.append(TEXT_1170);
    //Class/eIsSet.override.javajetinc
    }
    if (isImplementation && !genClass.getMixinGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1171);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1173);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1176);
    }
    stringBuffer.append(TEXT_1177);
    }
    stringBuffer.append(TEXT_1178);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1180);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1183);
    }
    stringBuffer.append(TEXT_1184);
    }
    stringBuffer.append(TEXT_1185);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1188);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) { List allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList());
    stringBuffer.append(TEXT_1189);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1192);
    }
    stringBuffer.append(TEXT_1193);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1196);
    }
    stringBuffer.append(TEXT_1197);
    }
    }
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1198);
    { boolean first = true;
    for (Iterator i=genClass.getToStringGenFeatures().iterator(); i.hasNext(); ) { GenFeature genFeature = (GenFeature)i.next();
    if (first) { first = false;
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.isUnsettable() && !genFeature.isListType()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1206);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1209);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1210);
    }
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1214);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1217);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1218);
    }
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isListType() && !genFeature.isReferenceType()){
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1223);
    }
    stringBuffer.append(TEXT_1224);
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1227);
    } else {
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1229);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1230);
    }
    if (isImplementation && genClass.isMapEntry()) { GenFeature keyFeature = genClass.getMapEntryKeyFeature(); GenFeature valueFeature = genClass.getMapEntryValueFeature();
    stringBuffer.append(TEXT_1231);
    if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1233);
    } else {
    stringBuffer.append(TEXT_1234);
    }
    stringBuffer.append(TEXT_1235);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1237);
    } else if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(keyFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1240);
    } else {
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(keyFeature.getImportedType());
    stringBuffer.append(TEXT_1242);
    }
    stringBuffer.append(TEXT_1243);
    if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1245);
    } else {
    stringBuffer.append(TEXT_1246);
    }
    stringBuffer.append(TEXT_1247);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1249);
    } else if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(valueFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1252);
    } else {
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(valueFeature.getImportedType());
    stringBuffer.append(TEXT_1254);
    }
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1258);
    }
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
    // TODO fix the space above
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_1260);
    return stringBuffer.toString();
  }
}
