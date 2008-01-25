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
  protected final String TEXT_75 = " " + NL + "\tpublic final static int _INTERNAL_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL;
  protected final String TEXT_78 = NL + "\t/**" + NL + "\t * The number of properties for this type." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_79 = NL + "\tpublic final static int INTERNAL_PROPERTY_COUNT = ";
  protected final String TEXT_80 = ";" + NL + "" + NL + "\tprotected int internalConvertIndex(int internalIndex)" + NL + "\t{" + NL + "\t\tswitch (internalIndex)" + NL + "\t\t{";
  protected final String TEXT_81 = NL + "\t\t\tcase _INTERNAL_";
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
  protected final String TEXT_144 = " getStaticType()" + NL + "\t{" + NL + "\t\treturn ((";
  protected final String TEXT_145 = ")";
  protected final String TEXT_146 = ".INSTANCE).get";
  protected final String TEXT_147 = "();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getStaticPropertyCount()" + NL + "\t{" + NL + "\t\treturn INTERNAL_PROPERTY_COUNT;" + NL + "\t}" + NL;
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
  protected final String TEXT_288 = " = createSequence(_INTERNAL_";
  protected final String TEXT_289 = ");";
  protected final String TEXT_290 = NL + "\t\t  ";
  protected final String TEXT_291 = " = createPropertyList(";
  protected final String TEXT_292 = ", ";
  protected final String TEXT_293 = ".class, ";
  protected final String TEXT_294 = ", ";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_297 = ";";
  protected final String TEXT_298 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_299 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_300 = ")eContainer();";
  protected final String TEXT_301 = NL + "\t\t";
  protected final String TEXT_302 = " ";
  protected final String TEXT_303 = " = (";
  protected final String TEXT_304 = ")eVirtualGet(";
  protected final String TEXT_305 = ", ";
  protected final String TEXT_306 = "_DEFAULT_";
  protected final String TEXT_307 = ");";
  protected final String TEXT_308 = NL + "\t\tif (";
  protected final String TEXT_309 = " != null && isProxy(";
  protected final String TEXT_310 = "))" + NL + "\t\t{" + NL + "\t\t\tObject old";
  protected final String TEXT_311 = " = ";
  protected final String TEXT_312 = ";" + NL + "\t\t\t";
  protected final String TEXT_313 = " = ";
  protected final String TEXT_314 = "resolveProxy(old";
  protected final String TEXT_315 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_316 = " != old";
  protected final String TEXT_317 = ")" + NL + "\t\t\t{";
  protected final String TEXT_318 = NL + "\t\t\t\t";
  protected final String TEXT_319 = " new";
  protected final String TEXT_320 = " = (";
  protected final String TEXT_321 = ")";
  protected final String TEXT_322 = ";";
  protected final String TEXT_323 = NL + "\t\t\t\tChangeContext changeContext = old";
  protected final String TEXT_324 = ".eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_325 = ", null, null);";
  protected final String TEXT_326 = NL + "\t\t\t\t";
  protected final String TEXT_327 = " changeContext =  old";
  protected final String TEXT_328 = ".eInverseRemove(this, ";
  protected final String TEXT_329 = ", ";
  protected final String TEXT_330 = ".class, null);";
  protected final String TEXT_331 = NL + "\t\t\t\tif (new";
  protected final String TEXT_332 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
  protected final String TEXT_333 = NL + "\t\t\t\t\tchangeContext = new";
  protected final String TEXT_334 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_335 = ", null, changeContext);";
  protected final String TEXT_336 = NL + "\t\t\t\t\tchangeContext =  new";
  protected final String TEXT_337 = ".eInverseAdd(this, ";
  protected final String TEXT_338 = ", ";
  protected final String TEXT_339 = ".class, changeContext);";
  protected final String TEXT_340 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (changeContext != null) dispatch(changeContext);";
  protected final String TEXT_341 = NL + "\t\t\t\teVirtualSet(";
  protected final String TEXT_342 = ", ";
  protected final String TEXT_343 = ");";
  protected final String TEXT_344 = NL + "\t\t\t\tif (isNotifying())" + NL + "\t\t\t\t\tnotify(ChangeKind.RESOLVE, _INTERNAL_";
  protected final String TEXT_345 = ", old";
  protected final String TEXT_346 = ", ";
  protected final String TEXT_347 = ");";
  protected final String TEXT_348 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_349 = NL + "\t\treturn (";
  protected final String TEXT_350 = ")eVirtualGet(";
  protected final String TEXT_351 = ", ";
  protected final String TEXT_352 = "_DEFAULT_";
  protected final String TEXT_353 = ");";
  protected final String TEXT_354 = NL + "\t\treturn (";
  protected final String TEXT_355 = " & ";
  protected final String TEXT_356 = "_EFLAG) != 0;";
  protected final String TEXT_357 = NL + "\t\treturn ";
  protected final String TEXT_358 = ";";
  protected final String TEXT_359 = NL + "\t\t";
  protected final String TEXT_360 = " ";
  protected final String TEXT_361 = " = basicGet";
  protected final String TEXT_362 = "();" + NL + "\t\treturn ";
  protected final String TEXT_363 = " != null && ";
  protected final String TEXT_364 = ".isProxy() ? ";
  protected final String TEXT_365 = "eResolveProxy((";
  protected final String TEXT_366 = ")";
  protected final String TEXT_367 = ") : ";
  protected final String TEXT_368 = ";";
  protected final String TEXT_369 = NL + "\t\treturn create";
  protected final String TEXT_370 = "(get";
  protected final String TEXT_371 = "(), getType(), _INTERNAL_";
  protected final String TEXT_372 = ");";
  protected final String TEXT_373 = NL + "\t\treturn (";
  protected final String TEXT_374 = ")((";
  protected final String TEXT_375 = ")get";
  protected final String TEXT_376 = "()).list(";
  protected final String TEXT_377 = ");";
  protected final String TEXT_378 = NL + "\t\treturn get";
  protected final String TEXT_379 = "(get";
  protected final String TEXT_380 = "(), getType(), _INTERNAL_";
  protected final String TEXT_381 = ");";
  protected final String TEXT_382 = NL + "\t\treturn ((";
  protected final String TEXT_383 = ")get";
  protected final String TEXT_384 = "()).list(";
  protected final String TEXT_385 = ");";
  protected final String TEXT_386 = NL + "\t\treturn ";
  protected final String TEXT_387 = "(";
  protected final String TEXT_388 = "(";
  protected final String TEXT_389 = ")get(get";
  protected final String TEXT_390 = "(), getType(), _INTERNAL_";
  protected final String TEXT_391 = ")";
  protected final String TEXT_392 = ").";
  protected final String TEXT_393 = "()";
  protected final String TEXT_394 = ";";
  protected final String TEXT_395 = NL + "\t\treturn ";
  protected final String TEXT_396 = "(";
  protected final String TEXT_397 = "(";
  protected final String TEXT_398 = ")get(get";
  protected final String TEXT_399 = "(), getType(), _INTERNAL_";
  protected final String TEXT_400 = ")";
  protected final String TEXT_401 = ").";
  protected final String TEXT_402 = "()";
  protected final String TEXT_403 = ";";
  protected final String TEXT_404 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_405 = "' ";
  protected final String TEXT_406 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_407 = NL + "\t}";
  protected final String TEXT_408 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_409 = " basicGet";
  protected final String TEXT_410 = "()" + NL + "\t{";
  protected final String TEXT_411 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_412 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_413 = ")eInternalContainer();";
  protected final String TEXT_414 = NL + "\t\treturn (";
  protected final String TEXT_415 = ")eVirtualGet(";
  protected final String TEXT_416 = ");";
  protected final String TEXT_417 = NL + "\t\treturn ";
  protected final String TEXT_418 = ";";
  protected final String TEXT_419 = NL + "\t\treturn (";
  protected final String TEXT_420 = ")get(get";
  protected final String TEXT_421 = "(), getType(), _INTERNAL_";
  protected final String TEXT_422 = ");";
  protected final String TEXT_423 = NL + "\t\treturn (";
  protected final String TEXT_424 = ")get";
  protected final String TEXT_425 = "().get(";
  protected final String TEXT_426 = ", false);";
  protected final String TEXT_427 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_428 = "' ";
  protected final String TEXT_429 = NL + "\t\t// -> do not perform proxy resolution" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_430 = NL + "\t}" + NL;
  protected final String TEXT_431 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicSet";
  protected final String TEXT_432 = "(";
  protected final String TEXT_433 = " new";
  protected final String TEXT_434 = ", ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_435 = NL + "\t\tObject old";
  protected final String TEXT_436 = " = eVirtualSet(";
  protected final String TEXT_437 = ", new";
  protected final String TEXT_438 = ");";
  protected final String TEXT_439 = NL + "\t\t";
  protected final String TEXT_440 = " old";
  protected final String TEXT_441 = " = ";
  protected final String TEXT_442 = ";" + NL + "\t\t";
  protected final String TEXT_443 = " = new";
  protected final String TEXT_444 = ";";
  protected final String TEXT_445 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_446 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_447 = NL + "\t\tboolean old";
  protected final String TEXT_448 = "_set_ = (";
  protected final String TEXT_449 = " & ";
  protected final String TEXT_450 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_451 = " |= ";
  protected final String TEXT_452 = "_ESETFLAG;";
  protected final String TEXT_453 = NL + "\t\tboolean old";
  protected final String TEXT_454 = "_set_ = ";
  protected final String TEXT_455 = "_set_;" + NL + "\t\t";
  protected final String TEXT_456 = "_set_ = true;";
  protected final String TEXT_457 = NL + "\t\tif (isNotifying())" + NL + "\t\t{";
  protected final String TEXT_458 = NL + "\t\t\taddNotification(this, ChangeKind.SET, _INTERNAL_";
  protected final String TEXT_459 = ", ";
  protected final String TEXT_460 = "isSetChange ? null : old";
  protected final String TEXT_461 = "old";
  protected final String TEXT_462 = ", new";
  protected final String TEXT_463 = ", ";
  protected final String TEXT_464 = "isSetChange";
  protected final String TEXT_465 = "!old";
  protected final String TEXT_466 = "_set_";
  protected final String TEXT_467 = ", changeContext);";
  protected final String TEXT_468 = NL + "\t\t\taddNotification(this, ChangeKind.SET, _INTERNAL_";
  protected final String TEXT_469 = ", ";
  protected final String TEXT_470 = "old";
  protected final String TEXT_471 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_472 = "old";
  protected final String TEXT_473 = ", new";
  protected final String TEXT_474 = ", changeContext);";
  protected final String TEXT_475 = NL + "\t\t}";
  protected final String TEXT_476 = NL + "\t\treturn changeContext;";
  protected final String TEXT_477 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_478 = "(), getType(), _INTERNAL_";
  protected final String TEXT_479 = ", new";
  protected final String TEXT_480 = ", changeContext);";
  protected final String TEXT_481 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_482 = "(), getType(), _INTERNAL_";
  protected final String TEXT_483 = ", new";
  protected final String TEXT_484 = ", changeContext);";
  protected final String TEXT_485 = NL + "\t\t// TODO: implement this method to set the contained '";
  protected final String TEXT_486 = "' ";
  protected final String TEXT_487 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_488 = NL + "\t}" + NL;
  protected final String TEXT_489 = NL + "\t/**" + NL + "\t * Sets the value of the '{@link ";
  protected final String TEXT_490 = "#";
  protected final String TEXT_491 = " <em>";
  protected final String TEXT_492 = "</em>}' ";
  protected final String TEXT_493 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param value the new value of the '<em>";
  protected final String TEXT_494 = "</em>' ";
  protected final String TEXT_495 = ".";
  protected final String TEXT_496 = NL + "\t * @see ";
  protected final String TEXT_497 = NL + "\t * @see #isSet";
  protected final String TEXT_498 = "()";
  protected final String TEXT_499 = NL + "\t * @see #unset";
  protected final String TEXT_500 = "()";
  protected final String TEXT_501 = NL + "\t * @see #";
  protected final String TEXT_502 = "()" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_503 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_504 = NL + "\tvoid set";
  protected final String TEXT_505 = "(";
  protected final String TEXT_506 = " value);" + NL;
  protected final String TEXT_507 = NL + "\tpublic void set";
  protected final String TEXT_508 = "(";
  protected final String TEXT_509 = " new";
  protected final String TEXT_510 = ")" + NL + "\t{";
  protected final String TEXT_511 = NL + "\t\t_set_(";
  protected final String TEXT_512 = ", ";
  protected final String TEXT_513 = "new ";
  protected final String TEXT_514 = "(";
  protected final String TEXT_515 = "new";
  protected final String TEXT_516 = ")";
  protected final String TEXT_517 = ");";
  protected final String TEXT_518 = NL + "\t\tif (new";
  protected final String TEXT_519 = " != eInternalContainer() || (eContainerFeatureID != ";
  protected final String TEXT_520 = " && new";
  protected final String TEXT_521 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_522 = ".isAncestor(this, ";
  protected final String TEXT_523 = "new";
  protected final String TEXT_524 = "))" + NL + "\t\t\t\tthrow new ";
  protected final String TEXT_525 = "(\"Recursive containment not allowed for \" + toString());";
  protected final String TEXT_526 = NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_527 = " != null)" + NL + "\t\t\t\tchangeContext = ((";
  protected final String TEXT_528 = ")new";
  protected final String TEXT_529 = ").eInverseAdd(this, ";
  protected final String TEXT_530 = ", ";
  protected final String TEXT_531 = ".class, changeContext);" + NL + "\t\t\tchangeContext = eBasicSetContainer((";
  protected final String TEXT_532 = ")new";
  protected final String TEXT_533 = ", ";
  protected final String TEXT_534 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_535 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, _INTERNAL_";
  protected final String TEXT_536 = ", new";
  protected final String TEXT_537 = ", new";
  protected final String TEXT_538 = ");";
  protected final String TEXT_539 = NL + "\t\t";
  protected final String TEXT_540 = " ";
  protected final String TEXT_541 = " = (";
  protected final String TEXT_542 = ")eVirtualGet(";
  protected final String TEXT_543 = ");";
  protected final String TEXT_544 = NL + "\t\tif (new";
  protected final String TEXT_545 = " != ";
  protected final String TEXT_546 = ")" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (";
  protected final String TEXT_547 = " != null)";
  protected final String TEXT_548 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_549 = ", this, OPPOSITE_FEATURE_BASE - _INTERNAL_";
  protected final String TEXT_550 = ", null, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_551 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_552 = ", this, OPPOSITE_FEATURE_BASE - _INTERNAL_";
  protected final String TEXT_553 = ", null, changeContext);";
  protected final String TEXT_554 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_555 = ", this, ";
  protected final String TEXT_556 = ", ";
  protected final String TEXT_557 = ".class, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_558 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_559 = ", this, ";
  protected final String TEXT_560 = ", ";
  protected final String TEXT_561 = ".class, changeContext);";
  protected final String TEXT_562 = NL + "\t\t\tchangeContext = basicSet";
  protected final String TEXT_563 = "(";
  protected final String TEXT_564 = "new";
  protected final String TEXT_565 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_566 = NL + "\t\telse" + NL + "\t\t{";
  protected final String TEXT_567 = NL + "\t\t\tboolean old";
  protected final String TEXT_568 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_569 = ");";
  protected final String TEXT_570 = NL + "\t\t\tboolean old";
  protected final String TEXT_571 = "_set_ = (";
  protected final String TEXT_572 = " & ";
  protected final String TEXT_573 = "_ESETFLAG) != 0;";
  protected final String TEXT_574 = NL + "\t\t\t";
  protected final String TEXT_575 = " |= ";
  protected final String TEXT_576 = "_ESETFLAG;";
  protected final String TEXT_577 = NL + "\t\t\tboolean old";
  protected final String TEXT_578 = "_set_ = ";
  protected final String TEXT_579 = "_set_;";
  protected final String TEXT_580 = NL + "\t\t\t";
  protected final String TEXT_581 = "_set_ = true;";
  protected final String TEXT_582 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.SET, _INTERNAL_";
  protected final String TEXT_583 = ", new";
  protected final String TEXT_584 = ", new";
  protected final String TEXT_585 = ", !old";
  protected final String TEXT_586 = "_set_);";
  protected final String TEXT_587 = NL + "\t\t}";
  protected final String TEXT_588 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, _INTERNAL_";
  protected final String TEXT_589 = ", new";
  protected final String TEXT_590 = ", new";
  protected final String TEXT_591 = ");";
  protected final String TEXT_592 = NL + "\t\t";
  protected final String TEXT_593 = " old";
  protected final String TEXT_594 = " = (";
  protected final String TEXT_595 = " & ";
  protected final String TEXT_596 = "_EFLAG) != 0;";
  protected final String TEXT_597 = NL + "\t\tif (new";
  protected final String TEXT_598 = ") ";
  protected final String TEXT_599 = " |= ";
  protected final String TEXT_600 = "_EFLAG; else ";
  protected final String TEXT_601 = " &= ~";
  protected final String TEXT_602 = "_EFLAG;";
  protected final String TEXT_603 = NL + "\t\t";
  protected final String TEXT_604 = " old";
  protected final String TEXT_605 = " = ";
  protected final String TEXT_606 = ";";
  protected final String TEXT_607 = NL + "\t\t";
  protected final String TEXT_608 = " ";
  protected final String TEXT_609 = " = new";
  protected final String TEXT_610 = " == null ? ";
  protected final String TEXT_611 = "_DEFAULT_ : new";
  protected final String TEXT_612 = ";";
  protected final String TEXT_613 = NL + "\t\t";
  protected final String TEXT_614 = " = new";
  protected final String TEXT_615 = " == null ? ";
  protected final String TEXT_616 = "_DEFAULT_ : new";
  protected final String TEXT_617 = ";";
  protected final String TEXT_618 = NL + "\t\t";
  protected final String TEXT_619 = " ";
  protected final String TEXT_620 = " = ";
  protected final String TEXT_621 = "new";
  protected final String TEXT_622 = ";";
  protected final String TEXT_623 = NL + "\t\t";
  protected final String TEXT_624 = " = ";
  protected final String TEXT_625 = "new";
  protected final String TEXT_626 = ";";
  protected final String TEXT_627 = NL + "\t\tObject old";
  protected final String TEXT_628 = " = eVirtualSet(";
  protected final String TEXT_629 = ", ";
  protected final String TEXT_630 = ");";
  protected final String TEXT_631 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_632 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_633 = NL + "\t\tboolean old";
  protected final String TEXT_634 = "_set_ = (";
  protected final String TEXT_635 = " & ";
  protected final String TEXT_636 = "_ESETFLAG) != 0;";
  protected final String TEXT_637 = NL + "\t\t";
  protected final String TEXT_638 = " |= ";
  protected final String TEXT_639 = "_ESETFLAG;";
  protected final String TEXT_640 = NL + "\t\tboolean old";
  protected final String TEXT_641 = "_set_ = ";
  protected final String TEXT_642 = "_set_;";
  protected final String TEXT_643 = NL + "\t\t";
  protected final String TEXT_644 = "_set_ = true;";
  protected final String TEXT_645 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, _INTERNAL_";
  protected final String TEXT_646 = ", ";
  protected final String TEXT_647 = "isSetChange ? ";
  protected final String TEXT_648 = "null";
  protected final String TEXT_649 = "_DEFAULT_";
  protected final String TEXT_650 = " : old";
  protected final String TEXT_651 = "old";
  protected final String TEXT_652 = ", ";
  protected final String TEXT_653 = "new";
  protected final String TEXT_654 = ", ";
  protected final String TEXT_655 = "isSetChange";
  protected final String TEXT_656 = "!old";
  protected final String TEXT_657 = "_set_";
  protected final String TEXT_658 = ");";
  protected final String TEXT_659 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, _INTERNAL_";
  protected final String TEXT_660 = ", ";
  protected final String TEXT_661 = "old";
  protected final String TEXT_662 = " == EVIRTUAL_NO_VALUE ? ";
  protected final String TEXT_663 = "null";
  protected final String TEXT_664 = "_DEFAULT_";
  protected final String TEXT_665 = " : old";
  protected final String TEXT_666 = "old";
  protected final String TEXT_667 = ", ";
  protected final String TEXT_668 = "new";
  protected final String TEXT_669 = ");";
  protected final String TEXT_670 = NL + "\t\tset(get";
  protected final String TEXT_671 = "(), getType(), _INTERNAL_";
  protected final String TEXT_672 = ", ";
  protected final String TEXT_673 = " new ";
  protected final String TEXT_674 = "(";
  protected final String TEXT_675 = "new";
  protected final String TEXT_676 = ")";
  protected final String TEXT_677 = ");";
  protected final String TEXT_678 = NL + "\t\t((";
  protected final String TEXT_679 = ".Internal)get";
  protected final String TEXT_680 = "()).set(";
  protected final String TEXT_681 = ", ";
  protected final String TEXT_682 = "new ";
  protected final String TEXT_683 = "(";
  protected final String TEXT_684 = "new";
  protected final String TEXT_685 = ")";
  protected final String TEXT_686 = ");";
  protected final String TEXT_687 = NL + "\t\t// TODO: implement this method to set the '";
  protected final String TEXT_688 = "' ";
  protected final String TEXT_689 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_690 = NL + "\t}" + NL;
  protected final String TEXT_691 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicUnset";
  protected final String TEXT_692 = "(ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_693 = NL + "\t\tObject old";
  protected final String TEXT_694 = " = eVirtualUnset(";
  protected final String TEXT_695 = ");";
  protected final String TEXT_696 = NL + "\t\t";
  protected final String TEXT_697 = " old";
  protected final String TEXT_698 = " = ";
  protected final String TEXT_699 = ";" + NL + "\t\t";
  protected final String TEXT_700 = " = null;";
  protected final String TEXT_701 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_702 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_703 = NL + "\t\tboolean old";
  protected final String TEXT_704 = "_set_ = (";
  protected final String TEXT_705 = " & ";
  protected final String TEXT_706 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_707 = " &= ~";
  protected final String TEXT_708 = "_ESETFLAG;";
  protected final String TEXT_709 = NL + "\t\tboolean old";
  protected final String TEXT_710 = "_set_ = ";
  protected final String TEXT_711 = "_set_;" + NL + "\t\t";
  protected final String TEXT_712 = "_set_ = false;";
  protected final String TEXT_713 = NL + "\t\tif (isNotifying())" + NL + "\t\t{";
  protected final String TEXT_714 = NL + "\t\t\taddNotification(this, ChangeKind.UNSET, _INTERNAL_";
  protected final String TEXT_715 = ", ";
  protected final String TEXT_716 = "isSetChange ? null : old";
  protected final String TEXT_717 = "old";
  protected final String TEXT_718 = ", null, ";
  protected final String TEXT_719 = "isSetChange";
  protected final String TEXT_720 = "!old";
  protected final String TEXT_721 = "_set_";
  protected final String TEXT_722 = ", changeContext);";
  protected final String TEXT_723 = NL + "\t\t\taddNotification(this, ChangeKind.UNSET, _INTERNAL_";
  protected final String TEXT_724 = ", ";
  protected final String TEXT_725 = "old";
  protected final String TEXT_726 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_727 = "old";
  protected final String TEXT_728 = ", null, changeContext);";
  protected final String TEXT_729 = NL + "\t\t}";
  protected final String TEXT_730 = NL + "\t\treturn changeContext;";
  protected final String TEXT_731 = NL + "\t\t// TODO: implement this method to unset the contained '";
  protected final String TEXT_732 = "' ";
  protected final String TEXT_733 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_734 = NL + "\t}" + NL;
  protected final String TEXT_735 = NL + "\t/**" + NL + "\t * Unsets the value of the '{@link ";
  protected final String TEXT_736 = "#";
  protected final String TEXT_737 = " <em>";
  protected final String TEXT_738 = "</em>}' ";
  protected final String TEXT_739 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_740 = NL + "\t * @see #isSet";
  protected final String TEXT_741 = "()";
  protected final String TEXT_742 = NL + "\t * @see #";
  protected final String TEXT_743 = "()";
  protected final String TEXT_744 = NL + "\t * @see #set";
  protected final String TEXT_745 = "(";
  protected final String TEXT_746 = ")";
  protected final String TEXT_747 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_748 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_749 = NL + "\tvoid unset";
  protected final String TEXT_750 = "();" + NL;
  protected final String TEXT_751 = NL + "\tpublic void unset";
  protected final String TEXT_752 = "()" + NL + "\t{";
  protected final String TEXT_753 = NL + "\t\tunset(";
  protected final String TEXT_754 = ");";
  protected final String TEXT_755 = NL + "\t\t((";
  protected final String TEXT_756 = ".Unsettable)get";
  protected final String TEXT_757 = "()).unset();";
  protected final String TEXT_758 = NL + "\t\t";
  protected final String TEXT_759 = " ";
  protected final String TEXT_760 = " = (";
  protected final String TEXT_761 = ")eVirtualGet(";
  protected final String TEXT_762 = ");";
  protected final String TEXT_763 = NL + "\t\tif (";
  protected final String TEXT_764 = " != null)" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;";
  protected final String TEXT_765 = NL + "\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_766 = ", this, EOPPOSITE_FEATURE_BASE - _INTERNAL_";
  protected final String TEXT_767 = ", null, changeContext);";
  protected final String TEXT_768 = NL + "\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_769 = ", this, ";
  protected final String TEXT_770 = ", ";
  protected final String TEXT_771 = ".class, changeContext);";
  protected final String TEXT_772 = NL + "\t\t\tchangeContext = basicUnset";
  protected final String TEXT_773 = "(changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}" + NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_774 = NL + "\t\t\tboolean old";
  protected final String TEXT_775 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_776 = ");";
  protected final String TEXT_777 = NL + "\t\t\tboolean old";
  protected final String TEXT_778 = "_set_ = (";
  protected final String TEXT_779 = " & ";
  protected final String TEXT_780 = "_ESETFLAG) != 0;";
  protected final String TEXT_781 = NL + "\t\t\t";
  protected final String TEXT_782 = " &= ~";
  protected final String TEXT_783 = "_ESETFLAG;";
  protected final String TEXT_784 = NL + "\t\t\tboolean old";
  protected final String TEXT_785 = "_set_ = ";
  protected final String TEXT_786 = "_set_;";
  protected final String TEXT_787 = NL + "\t\t\t";
  protected final String TEXT_788 = "_set_ = false;";
  protected final String TEXT_789 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.UNSET, _INTERNAL_";
  protected final String TEXT_790 = ", null, null, old";
  protected final String TEXT_791 = "_set_);";
  protected final String TEXT_792 = NL + "    \t}";
  protected final String TEXT_793 = NL + "\t\t";
  protected final String TEXT_794 = " old";
  protected final String TEXT_795 = " = (";
  protected final String TEXT_796 = " & ";
  protected final String TEXT_797 = "_EFLAG) != 0;";
  protected final String TEXT_798 = NL + "\t\tObject old";
  protected final String TEXT_799 = " = eVirtualUnset(";
  protected final String TEXT_800 = ");";
  protected final String TEXT_801 = NL + "\t\t";
  protected final String TEXT_802 = " old";
  protected final String TEXT_803 = " = ";
  protected final String TEXT_804 = ";";
  protected final String TEXT_805 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_806 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_807 = NL + "\t\tboolean old";
  protected final String TEXT_808 = "_set_ = (";
  protected final String TEXT_809 = " & ";
  protected final String TEXT_810 = "_ESETFLAG) != 0;";
  protected final String TEXT_811 = NL + "\t\tboolean old";
  protected final String TEXT_812 = "_set_ = ";
  protected final String TEXT_813 = "_set_;";
  protected final String TEXT_814 = NL + "\t\t";
  protected final String TEXT_815 = " = null;";
  protected final String TEXT_816 = NL + "\t\t";
  protected final String TEXT_817 = " &= ~";
  protected final String TEXT_818 = "_ESETFLAG;";
  protected final String TEXT_819 = NL + "\t\t";
  protected final String TEXT_820 = "_set_ = false;";
  protected final String TEXT_821 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, _INTERNAL_";
  protected final String TEXT_822 = ", ";
  protected final String TEXT_823 = "isSetChange ? old";
  protected final String TEXT_824 = " : null";
  protected final String TEXT_825 = "old";
  protected final String TEXT_826 = ", null, ";
  protected final String TEXT_827 = "isSetChange";
  protected final String TEXT_828 = "old";
  protected final String TEXT_829 = "_set_";
  protected final String TEXT_830 = ");";
  protected final String TEXT_831 = NL + "\t\tif (";
  protected final String TEXT_832 = "_DEFAULT_) ";
  protected final String TEXT_833 = " |= ";
  protected final String TEXT_834 = "_EFLAG; else ";
  protected final String TEXT_835 = " &= ~";
  protected final String TEXT_836 = "_EFLAG;";
  protected final String TEXT_837 = NL + "\t\t";
  protected final String TEXT_838 = " = ";
  protected final String TEXT_839 = "_DEFAULT_;";
  protected final String TEXT_840 = NL + "\t\t";
  protected final String TEXT_841 = " &= ~";
  protected final String TEXT_842 = "_ESETFLAG;";
  protected final String TEXT_843 = NL + "\t\t";
  protected final String TEXT_844 = "_set_ = false;";
  protected final String TEXT_845 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, _INTERNAL_";
  protected final String TEXT_846 = ", ";
  protected final String TEXT_847 = "isSetChange ? old";
  protected final String TEXT_848 = " : ";
  protected final String TEXT_849 = "_DEFAULT_";
  protected final String TEXT_850 = "old";
  protected final String TEXT_851 = ", ";
  protected final String TEXT_852 = "_DEFAULT_, ";
  protected final String TEXT_853 = "isSetChange";
  protected final String TEXT_854 = "old";
  protected final String TEXT_855 = "_set_";
  protected final String TEXT_856 = ");";
  protected final String TEXT_857 = NL + "        unset(get";
  protected final String TEXT_858 = "(), getType(), _INTERNAL_";
  protected final String TEXT_859 = ");";
  protected final String TEXT_860 = NL + "        unset";
  protected final String TEXT_861 = "(get";
  protected final String TEXT_862 = "());";
  protected final String TEXT_863 = NL + "\t\t// TODO: implement this method to unset the '";
  protected final String TEXT_864 = "' ";
  protected final String TEXT_865 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_866 = NL + "\t}" + NL;
  protected final String TEXT_867 = NL + "\t/**" + NL + "\t * Returns whether the value of the '{@link ";
  protected final String TEXT_868 = "#";
  protected final String TEXT_869 = " <em>";
  protected final String TEXT_870 = "</em>}' ";
  protected final String TEXT_871 = " is set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return whether the value of the '<em>";
  protected final String TEXT_872 = "</em>' ";
  protected final String TEXT_873 = " is set.";
  protected final String TEXT_874 = NL + "\t * @see #unset";
  protected final String TEXT_875 = "()";
  protected final String TEXT_876 = NL + "\t * @see #";
  protected final String TEXT_877 = "()";
  protected final String TEXT_878 = NL + "\t * @see #set";
  protected final String TEXT_879 = "(";
  protected final String TEXT_880 = ")";
  protected final String TEXT_881 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_882 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_883 = NL + "\tboolean isSet";
  protected final String TEXT_884 = "();" + NL;
  protected final String TEXT_885 = NL + "\tpublic boolean isSet";
  protected final String TEXT_886 = "()" + NL + "\t{";
  protected final String TEXT_887 = NL + "\t\treturn isSet(";
  protected final String TEXT_888 = ");";
  protected final String TEXT_889 = NL + "\t\t";
  protected final String TEXT_890 = " ";
  protected final String TEXT_891 = " = (";
  protected final String TEXT_892 = ")eVirtualGet(";
  protected final String TEXT_893 = ");";
  protected final String TEXT_894 = NL + "\t\treturn ";
  protected final String TEXT_895 = " != null && ((";
  protected final String TEXT_896 = ".Unsettable)";
  protected final String TEXT_897 = ").isSet();";
  protected final String TEXT_898 = NL + "\t\treturn eVirtualIsSet(";
  protected final String TEXT_899 = ");";
  protected final String TEXT_900 = NL + "\t\treturn (";
  protected final String TEXT_901 = " & ";
  protected final String TEXT_902 = "_ESETFLAG) != 0;";
  protected final String TEXT_903 = NL + "\t\treturn ";
  protected final String TEXT_904 = "_set_;";
  protected final String TEXT_905 = NL + "        return isSet(get";
  protected final String TEXT_906 = "(), getType(), _INTERNAL_";
  protected final String TEXT_907 = ");";
  protected final String TEXT_908 = NL + "\t\treturn !((";
  protected final String TEXT_909 = ".Internal)get";
  protected final String TEXT_910 = "()).isEmpty(";
  protected final String TEXT_911 = ");";
  protected final String TEXT_912 = NL + "\t\t// TODO: implement this method to return whether the '";
  protected final String TEXT_913 = "' ";
  protected final String TEXT_914 = " is set" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_915 = NL + "\t}" + NL;
  protected final String TEXT_916 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_917 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_918 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_919 = NL + "\t * @model ";
  protected final String TEXT_920 = NL + "\t *        ";
  protected final String TEXT_921 = NL + "\t * @model";
  protected final String TEXT_922 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_923 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_924 = NL + "\t";
  protected final String TEXT_925 = " ";
  protected final String TEXT_926 = "(";
  protected final String TEXT_927 = ")";
  protected final String TEXT_928 = ";" + NL;
  protected final String TEXT_929 = NL + "\tpublic ";
  protected final String TEXT_930 = " ";
  protected final String TEXT_931 = "(";
  protected final String TEXT_932 = ")";
  protected final String TEXT_933 = NL + "\t{";
  protected final String TEXT_934 = NL + "\t\t";
  protected final String TEXT_935 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_936 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_937 = ".add" + NL + "\t\t\t\t\t(new ";
  protected final String TEXT_938 = NL + "\t\t\t\t\t\t(";
  protected final String TEXT_939 = ".ERROR," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_940 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_941 = ".";
  protected final String TEXT_942 = "," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_943 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
  protected final String TEXT_944 = "\", ";
  protected final String TEXT_945 = ".getObjectLabel(this, ";
  protected final String TEXT_946 = ") }),";
  protected final String TEXT_947 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
  protected final String TEXT_948 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_949 = NL + "\t}" + NL;
  protected final String TEXT_950 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eInverseAdd(";
  protected final String TEXT_951 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_952 = NL + "\t\t\tcase ";
  protected final String TEXT_953 = ":";
  protected final String TEXT_954 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_955 = ")((";
  protected final String TEXT_956 = ".InternalMapView)";
  protected final String TEXT_957 = "()).eMap()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_958 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_959 = ")";
  protected final String TEXT_960 = "()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_961 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
  protected final String TEXT_962 = ", changeContext);";
  protected final String TEXT_963 = NL + "\t\t\t\t";
  protected final String TEXT_964 = " ";
  protected final String TEXT_965 = " = (";
  protected final String TEXT_966 = ")eVirtualGet(";
  protected final String TEXT_967 = ");";
  protected final String TEXT_968 = NL + "\t\t\t\tif (";
  protected final String TEXT_969 = " != null)";
  protected final String TEXT_970 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_971 = ")";
  protected final String TEXT_972 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_973 = ", null, changeContext);";
  protected final String TEXT_974 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_975 = ")";
  protected final String TEXT_976 = ").eInverseRemove(this, ";
  protected final String TEXT_977 = ", ";
  protected final String TEXT_978 = ".class, changeContext);";
  protected final String TEXT_979 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_980 = "((";
  protected final String TEXT_981 = ")otherEnd, changeContext);";
  protected final String TEXT_982 = NL + "\t\t}";
  protected final String TEXT_983 = NL + "\t\treturn super.eInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_984 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_985 = NL + "\t}" + NL;
  protected final String TEXT_986 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext inverseRemove(";
  protected final String TEXT_987 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_988 = NL + "\t\t\tcase ";
  protected final String TEXT_989 = ":";
  protected final String TEXT_990 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_991 = ")((";
  protected final String TEXT_992 = ".InternalMapView)";
  protected final String TEXT_993 = "()).eMap()).basicRemove(otherEnd, changeContext);";
  protected final String TEXT_994 = NL + "\t\t\t\treturn removeFrom";
  protected final String TEXT_995 = "(";
  protected final String TEXT_996 = "(), otherEnd, changeContext);";
  protected final String TEXT_997 = NL + "\t\t\t\treturn removeFromList(";
  protected final String TEXT_998 = "(), otherEnd, changeContext);";
  protected final String TEXT_999 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
  protected final String TEXT_1000 = ", changeContext);";
  protected final String TEXT_1001 = NL + "\t\t\t\treturn basicUnset";
  protected final String TEXT_1002 = "(changeContext);";
  protected final String TEXT_1003 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1004 = "(null, changeContext);";
  protected final String TEXT_1005 = NL + "\t\t}";
  protected final String TEXT_1006 = NL + "\t\treturn super.inverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_1007 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_1008 = NL + "\t}" + NL;
  protected final String TEXT_1009 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eBasicRemoveFromContainerFeature(ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID)" + NL + "\t\t{";
  protected final String TEXT_1010 = NL + "\t\t\tcase ";
  protected final String TEXT_1011 = ":" + NL + "\t\t\t\treturn eInternalContainer().eInverseRemove(this, ";
  protected final String TEXT_1012 = ", ";
  protected final String TEXT_1013 = ".class, changeContext);";
  protected final String TEXT_1014 = NL + "\t\t}";
  protected final String TEXT_1015 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(changeContext);";
  protected final String TEXT_1016 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(changeContext);";
  protected final String TEXT_1017 = NL + "\t}" + NL;
  protected final String TEXT_1018 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object get(int propertyIndex, boolean resolve)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1019 = NL + "\t\t\tcase ";
  protected final String TEXT_1020 = ":";
  protected final String TEXT_1021 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1022 = "() ? Boolean.TRUE : Boolean.FALSE;";
  protected final String TEXT_1023 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_1024 = "(";
  protected final String TEXT_1025 = "());";
  protected final String TEXT_1026 = NL + "\t\t\t\tif (resolve) return ";
  protected final String TEXT_1027 = "();" + NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1028 = "();";
  protected final String TEXT_1029 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1030 = ".InternalMapView)";
  protected final String TEXT_1031 = "()).eMap();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1032 = "();";
  protected final String TEXT_1033 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1034 = "();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1035 = "().map();";
  protected final String TEXT_1036 = NL + "\t\t\t\t// XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view" + NL + "\t\t\t\t//if (coreType) " + NL + "\t\t\t\treturn ";
  protected final String TEXT_1037 = "();";
  protected final String TEXT_1038 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1039 = "();" + NL + "\t\t\t\treturn ((";
  protected final String TEXT_1040 = ".Internal)";
  protected final String TEXT_1041 = "()).getWrapper();";
  protected final String TEXT_1042 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1043 = "();";
  protected final String TEXT_1044 = NL + "\t\t}";
  protected final String TEXT_1045 = NL + "\t\treturn super.get(propertyIndex, resolve);";
  protected final String TEXT_1046 = NL + "\t\treturn eDynamicGet(propertyIndex, resolve, coreType);";
  protected final String TEXT_1047 = NL + "\t}" + NL;
  protected final String TEXT_1048 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void set(int propertyIndex, Object newValue)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1049 = NL + "\t\t\tcase ";
  protected final String TEXT_1050 = ":";
  protected final String TEXT_1051 = NL + "      \tset";
  protected final String TEXT_1052 = "(";
  protected final String TEXT_1053 = "(), newValue);";
  protected final String TEXT_1054 = NL + "\t\t\t\t((";
  protected final String TEXT_1055 = ".Internal)";
  protected final String TEXT_1056 = "()).set(newValue);";
  protected final String TEXT_1057 = NL + "\t\t\t\t((";
  protected final String TEXT_1058 = ".Setting)((";
  protected final String TEXT_1059 = ".InternalMapView)";
  protected final String TEXT_1060 = "()).eMap()).set(newValue);";
  protected final String TEXT_1061 = NL + "\t\t\t\t((";
  protected final String TEXT_1062 = ".Setting)";
  protected final String TEXT_1063 = "()).set(newValue);";
  protected final String TEXT_1064 = NL + "\t\t\t\t";
  protected final String TEXT_1065 = "().clear();" + NL + "\t\t\t\t";
  protected final String TEXT_1066 = "().addAll((";
  protected final String TEXT_1067 = ")newValue);";
  protected final String TEXT_1068 = NL + "\t\t\t\tset";
  protected final String TEXT_1069 = "(((";
  protected final String TEXT_1070 = ")newValue).";
  protected final String TEXT_1071 = "());";
  protected final String TEXT_1072 = NL + "\t\t\t\tset";
  protected final String TEXT_1073 = "((";
  protected final String TEXT_1074 = ")newValue);";
  protected final String TEXT_1075 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1076 = NL + "\t\t}";
  protected final String TEXT_1077 = NL + "\t\tsuper.set(propertyIndex, newValue);";
  protected final String TEXT_1078 = NL + "\t\teDynamicSet(propertyIndex, newValue);";
  protected final String TEXT_1079 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void unset(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1080 = NL + "\t\t\tcase ";
  protected final String TEXT_1081 = ":";
  protected final String TEXT_1082 = NL + "\t\t\t\tunset";
  protected final String TEXT_1083 = "(";
  protected final String TEXT_1084 = "());";
  protected final String TEXT_1085 = NL + "\t\t\t\t";
  protected final String TEXT_1086 = "().clear();";
  protected final String TEXT_1087 = NL + "\t\t\t\tunset";
  protected final String TEXT_1088 = "();";
  protected final String TEXT_1089 = NL + "\t\t\t\tset";
  protected final String TEXT_1090 = "((";
  protected final String TEXT_1091 = ")null);";
  protected final String TEXT_1092 = NL + "\t\t\t\tset";
  protected final String TEXT_1093 = "(";
  protected final String TEXT_1094 = "_DEFAULT_);";
  protected final String TEXT_1095 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1096 = NL + "\t\t}";
  protected final String TEXT_1097 = NL + "\t\tsuper.unset(propertyIndex);";
  protected final String TEXT_1098 = NL + "\t\teDynamicUnset(propertyIndex);";
  protected final String TEXT_1099 = NL + "\t}" + NL;
  protected final String TEXT_1100 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSet(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1101 = NL + "\t\t\tcase ";
  protected final String TEXT_1102 = ":";
  protected final String TEXT_1103 = NL + "\t\t\t\treturn !is";
  protected final String TEXT_1104 = "Empty(";
  protected final String TEXT_1105 = "());";
  protected final String TEXT_1106 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1107 = " != null && !is";
  protected final String TEXT_1108 = "Empty(";
  protected final String TEXT_1109 = "());";
  protected final String TEXT_1110 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1111 = " != null && !";
  protected final String TEXT_1112 = ".isEmpty();";
  protected final String TEXT_1113 = NL + "\t\t\t\t";
  protected final String TEXT_1114 = " ";
  protected final String TEXT_1115 = " = (";
  protected final String TEXT_1116 = ")eVirtualGet(";
  protected final String TEXT_1117 = ");" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1118 = " != null && !";
  protected final String TEXT_1119 = ".isEmpty();";
  protected final String TEXT_1120 = NL + "\t\t\t\treturn !";
  protected final String TEXT_1121 = "().isEmpty();";
  protected final String TEXT_1122 = NL + "\t\t\t\treturn isSet";
  protected final String TEXT_1123 = "();";
  protected final String TEXT_1124 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1125 = " != null;";
  protected final String TEXT_1126 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1127 = ") != null;";
  protected final String TEXT_1128 = NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1129 = "() != null;";
  protected final String TEXT_1130 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1131 = " != null;";
  protected final String TEXT_1132 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1133 = ") != null;";
  protected final String TEXT_1134 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1135 = "() != null;";
  protected final String TEXT_1136 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1137 = " & ";
  protected final String TEXT_1138 = "_EFLAG) != 0) != ";
  protected final String TEXT_1139 = "_DEFAULT_;";
  protected final String TEXT_1140 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1141 = " != ";
  protected final String TEXT_1142 = "_DEFAULT_;";
  protected final String TEXT_1143 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1144 = ", ";
  protected final String TEXT_1145 = "_DEFAULT_) != ";
  protected final String TEXT_1146 = "_DEFAULT_;";
  protected final String TEXT_1147 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1148 = "() != ";
  protected final String TEXT_1149 = "_DEFAULT_;";
  protected final String TEXT_1150 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1151 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1152 = " != null : !";
  protected final String TEXT_1153 = "_DEFAULT_.equals(";
  protected final String TEXT_1154 = ");";
  protected final String TEXT_1155 = NL + "\t\t\t\t";
  protected final String TEXT_1156 = " ";
  protected final String TEXT_1157 = " = (";
  protected final String TEXT_1158 = ")eVirtualGet(";
  protected final String TEXT_1159 = ", ";
  protected final String TEXT_1160 = "_DEFAULT_);" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1161 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1162 = " != null : !";
  protected final String TEXT_1163 = "_DEFAULT_.equals(";
  protected final String TEXT_1164 = ");";
  protected final String TEXT_1165 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1166 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1167 = "() != null : !";
  protected final String TEXT_1168 = "_DEFAULT_.equals(";
  protected final String TEXT_1169 = "());";
  protected final String TEXT_1170 = NL + "\t\t}";
  protected final String TEXT_1171 = NL + "\t\treturn super.isSet(propertyIndex);";
  protected final String TEXT_1172 = NL + "\t\treturn eDynamicIsSet(propertyIndex);";
  protected final String TEXT_1173 = NL + "\t}" + NL;
  protected final String TEXT_1174 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1175 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1176 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1177 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1178 = ": return ";
  protected final String TEXT_1179 = ";";
  protected final String TEXT_1180 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1181 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1182 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1183 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1184 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1185 = ": return ";
  protected final String TEXT_1186 = ";";
  protected final String TEXT_1187 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1188 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);" + NL + "\t}" + NL;
  protected final String TEXT_1189 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_1190 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualValues(Object[] newValues)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1191 = " = newValues;" + NL + "\t}" + NL;
  protected final String TEXT_1192 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1193 = NL + "\t\t\tcase ";
  protected final String TEXT_1194 = " :" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1195 = ";";
  protected final String TEXT_1196 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualIndexBits(int offset, int newIndexBits)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1197 = NL + "\t\t\tcase ";
  protected final String TEXT_1198 = " :" + NL + "\t\t\t\t";
  protected final String TEXT_1199 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_1200 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_1201 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String toString()" + NL + "\t{" + NL + "\t\tif (isProxy(this)) return super.toString();" + NL + "" + NL + "\t\tStringBuffer result = new StringBuffer(super.toString());";
  protected final String TEXT_1202 = NL + "\t\tresult.append(\" (";
  protected final String TEXT_1203 = ": \");";
  protected final String TEXT_1204 = NL + "\t\tresult.append(\", ";
  protected final String TEXT_1205 = ": \");";
  protected final String TEXT_1206 = NL + "\t\tif (eVirtualIsSet(";
  protected final String TEXT_1207 = ")) result.append(eVirtualGet(";
  protected final String TEXT_1208 = ")); else result.append(\"<unset>\");";
  protected final String TEXT_1209 = NL + "\t\tif (";
  protected final String TEXT_1210 = "(";
  protected final String TEXT_1211 = " & ";
  protected final String TEXT_1212 = "_ESETFLAG) != 0";
  protected final String TEXT_1213 = "_set_";
  protected final String TEXT_1214 = ") result.append((";
  protected final String TEXT_1215 = " & ";
  protected final String TEXT_1216 = "_EFLAG) != 0); else result.append(\"<unset>\");";
  protected final String TEXT_1217 = NL + "\t\tif (";
  protected final String TEXT_1218 = "(";
  protected final String TEXT_1219 = " & ";
  protected final String TEXT_1220 = "_ESETFLAG) != 0";
  protected final String TEXT_1221 = "_set_";
  protected final String TEXT_1222 = ") result.append(";
  protected final String TEXT_1223 = "); else result.append(\"<unset>\");";
  protected final String TEXT_1224 = NL + "\t\tresult.append(eVirtualGet(";
  protected final String TEXT_1225 = ", ";
  protected final String TEXT_1226 = "_DEFAULT_";
  protected final String TEXT_1227 = "));";
  protected final String TEXT_1228 = NL + "\t\tresult.append((";
  protected final String TEXT_1229 = " & ";
  protected final String TEXT_1230 = "_EFLAG) != 0);";
  protected final String TEXT_1231 = NL + "\t\tresult.append(";
  protected final String TEXT_1232 = ");";
  protected final String TEXT_1233 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}" + NL;
  protected final String TEXT_1234 = NL + "\tpublic static class ConcreteBase extends ";
  protected final String TEXT_1235 = NL + "\t{" + NL + "\t\tpublic ConcreteBase()" + NL + "\t\t{" + NL + "\t\t\tsuper();" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_1236 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)" + NL + "\t\t{" + NL + "\t\t\tObject theKey = getKey();" + NL + "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL + "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic Object getKey()" + NL + "\t{" + NL + "  \t";
  protected final String TEXT_1237 = NL + "\t\treturn new ";
  protected final String TEXT_1238 = "(getTypedKey());" + NL + " \t";
  protected final String TEXT_1239 = NL + "\t\treturn getTypedKey();" + NL + "  \t";
  protected final String TEXT_1240 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(Object key)" + NL + "\t{";
  protected final String TEXT_1241 = NL + "\t\tgetTypedKey().addAll((";
  protected final String TEXT_1242 = ")key);";
  protected final String TEXT_1243 = NL + "\t\tsetTypedKey(((";
  protected final String TEXT_1244 = ")key).";
  protected final String TEXT_1245 = "());";
  protected final String TEXT_1246 = NL + "\t\tsetTypedKey((";
  protected final String TEXT_1247 = ")key);";
  protected final String TEXT_1248 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getValue()" + NL + "\t{" + NL + " \t";
  protected final String TEXT_1249 = NL + "\t\treturn new ";
  protected final String TEXT_1250 = "(getTypedValue());" + NL + " \t";
  protected final String TEXT_1251 = NL + "\t\treturn getTypedValue();" + NL + " \t";
  protected final String TEXT_1252 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object setValue(Object value)" + NL + "\t{" + NL + "\t\tObject oldValue = getValue();" + NL + "  \t";
  protected final String TEXT_1253 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll((";
  protected final String TEXT_1254 = ")value);" + NL + "  \t";
  protected final String TEXT_1255 = NL + "\t\tsetTypedValue(((";
  protected final String TEXT_1256 = ")value).";
  protected final String TEXT_1257 = "());" + NL + "  \t";
  protected final String TEXT_1258 = NL + "\t\tsetTypedValue((";
  protected final String TEXT_1259 = ")value);" + NL + "  \t";
  protected final String TEXT_1260 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1261 = " getEMap()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1262 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
  protected final String TEXT_1263 = ")container.get(eContainmentFeature());" + NL + "\t}";
  protected final String TEXT_1264 = NL + "} //";
  protected final String TEXT_1265 = NL;

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
           featureValue = base.getImportedClassName() + "." + genFeature.getUpperName();
         } else {
           String baseCountID = base.getImportedClassName() + "." + "SDO_PROPERTY_COUNT";
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
           featureValue = base.getImportedClassName() + "." + genFeature.getUpperName();
         } else {
           String baseCountID = base.getImportedClassName() + "." + "EXTENDED_PROPERTY_COUNT";
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
    String baseCountID = base.getImportedClassName() + "." + "SDO_PROPERTY_COUNT";
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
    String baseCountID = base.getImportedClassName() + "." + "EXTENDED_PROPERTY_COUNT";
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
    featureValue = base.getImportedClassName() + "._INTERNAL_" + genFeature.getUpperName();
    } else {
    String baseCountID = base.getImportedClassName() + "." + "INTERNAL_PROPERTY_COUNT";
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
      String baseCountID = base.getImportedClassName() + "." + "INTERNAL_PROPERTY_COUNT";
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
    stringBuffer.append(SDOGenUtil.getStaticDefaultValue(genFeature));
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
    stringBuffer.append(SDOGenUtil.getListKind(genFeature, genFeature.isUnsettable()));
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_294);
    stringBuffer.append(genFeature.isBidirectional()?genFeature.getReverse().getUpperName():"0" );
    stringBuffer.append(TEXT_295);
    }}
    stringBuffer.append(TEXT_296);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
    stringBuffer.append(TEXT_297);
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_298);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_299);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_300);
    } else {
    if (genFeature.isResolveProxies()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_301);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_303);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_304);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_305);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_306);
    }
    stringBuffer.append(TEXT_307);
    }
    stringBuffer.append(TEXT_308);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_309);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_312);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_313);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_315);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_317);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_318);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_319);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_321);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_322);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_323);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_324);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_325);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_326);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.ChangeContext"));
    stringBuffer.append(TEXT_327);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_329);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_330);
    }
    stringBuffer.append(TEXT_331);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_332);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_333);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_334);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_335);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_336);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_337);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_338);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_339);
    }
    stringBuffer.append(TEXT_340);
    } else if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_341);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_343);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_344);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_347);
    }
    stringBuffer.append(TEXT_348);
    }
    if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_349);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_350);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_351);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_352);
    }
    stringBuffer.append(TEXT_353);
    } else if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_354);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_355);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_356);
    } else {
    stringBuffer.append(TEXT_357);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_358);
    }
    }
    } else {//volatile
    if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_359);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_360);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_361);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_362);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_365);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_366);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_367);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_368);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); // AAAA
    if (genFeature.isFeatureMapType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_369);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_370);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_371);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_372);
    } else {
    stringBuffer.append(TEXT_373);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_374);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_376);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_377);
    }
    } else if (genFeature.isListType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_378);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_379);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_380);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_381);
    } else {
    stringBuffer.append(TEXT_382);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_383);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_384);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_385);
    }
    } else {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_386);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_387);
    }
    stringBuffer.append(TEXT_388);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_390);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_391);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_392);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_393);
    }
    stringBuffer.append(TEXT_394);
    } else {
    stringBuffer.append(TEXT_395);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_396);
    }
    stringBuffer.append(TEXT_397);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_398);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_399);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_400);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_401);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_402);
    }
    stringBuffer.append(TEXT_403);
    }
    }
    } else {
    stringBuffer.append(TEXT_404);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_406);
    //Class/getGenFeature.todo.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_407);
    }
    //Class/getGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
    stringBuffer.append(TEXT_408);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_410);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_411);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_412);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_413);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_414);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_415);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_416);
    } else {
    stringBuffer.append(TEXT_417);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_418);
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //BBBB
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_419);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_421);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_422);
    } else {
    stringBuffer.append(TEXT_423);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_424);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_426);
    }
    } else {
    stringBuffer.append(TEXT_427);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_428);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_429);
    //Class/basicGetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_430);
    //Class/basicGetGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_431);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_432);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_434);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_437);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_438);
    } else {
    stringBuffer.append(TEXT_439);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_441);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_442);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_443);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_444);
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_445);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_446);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_447);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_448);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_450);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_451);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_452);
    } else {
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_454);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_455);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_456);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_457);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_458);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_459);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_460);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_461);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_462);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_463);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_464);
    } else {
    stringBuffer.append(TEXT_465);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_466);
    }
    stringBuffer.append(TEXT_467);
    } else {
    stringBuffer.append(TEXT_468);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_469);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_470);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_472);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_473);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_474);
    }
    stringBuffer.append(TEXT_475);
    }
    stringBuffer.append(TEXT_476);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //CCCC
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_477);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_478);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_479);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_480);
    } else {
    stringBuffer.append(TEXT_481);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_482);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_483);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_484);
    }
    } else {
    stringBuffer.append(TEXT_485);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_486);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_487);
    //Class/basicSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_488);
    //Class/basicSetGenFeature.override.javajetinc
    }
    if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
    if (isInterface) { 
    stringBuffer.append(TEXT_489);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_491);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_492);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_493);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_494);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_495);
    if (genFeature.isEnumType()) {
    stringBuffer.append(TEXT_496);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_497);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_498);
    }
    if (!genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_499);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_500);
    }
    }
    stringBuffer.append(TEXT_501);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_502);
    } else {
    stringBuffer.append(TEXT_503);
    }
    if (!isImplementation) { 
    stringBuffer.append(TEXT_504);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_505);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_506);
    } else {
    stringBuffer.append(TEXT_507);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_508);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_509);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_510);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_511);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_512);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_513);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_514);
    }
    stringBuffer.append(TEXT_515);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_516);
    }
    stringBuffer.append(TEXT_517);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_518);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_519);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_520);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_521);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_522);
    stringBuffer.append(genFeature.getEObjectCast());
    stringBuffer.append(TEXT_523);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_524);
    stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_527);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_528);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_529);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_530);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_531);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_533);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_534);
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_535);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_536);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_537);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_538);
    }
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_539);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_541);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_542);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_543);
    }
    stringBuffer.append(TEXT_544);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_545);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_546);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_547);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_548);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_551);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_552);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_553);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_554);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_555);
    stringBuffer.append(SDOGenUtil.getQualifiedInternalPropertyID(reverseFeature));
    stringBuffer.append(TEXT_556);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_557);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_559);
    stringBuffer.append(SDOGenUtil.getQualifiedInternalPropertyID(reverseFeature));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_561);
    }
    stringBuffer.append(TEXT_562);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_563);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_564);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_565);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_566);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_567);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_568);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_569);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_570);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_571);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_572);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_573);
    }
    stringBuffer.append(TEXT_574);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_576);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_577);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_578);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_579);
    }
    stringBuffer.append(TEXT_580);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_581);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_582);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_583);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_584);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_585);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_586);
    }
    stringBuffer.append(TEXT_587);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_588);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_589);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_590);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_591);
    }
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_592);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_593);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_594);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_596);
    }
    stringBuffer.append(TEXT_597);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_598);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_599);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_600);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_602);
    } else {
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_603);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_604);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_605);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_606);
    }
    }
    if (genFeature.isEnumType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_607);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_608);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_609);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_610);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_611);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_612);
    } else {
    stringBuffer.append(TEXT_613);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_614);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_615);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_616);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_617);
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_618);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_619);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_620);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_621);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_622);
    } else {
    stringBuffer.append(TEXT_623);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_624);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_625);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_626);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_627);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_628);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_629);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_630);
    }
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_631);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_632);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_633);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_634);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_636);
    }
    stringBuffer.append(TEXT_637);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_638);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_639);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_640);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_641);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_642);
    }
    stringBuffer.append(TEXT_643);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_644);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_645);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_646);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_647);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_648);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_649);
    }
    stringBuffer.append(TEXT_650);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_651);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_652);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_653);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_654);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_655);
    } else {
    stringBuffer.append(TEXT_656);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_657);
    }
    stringBuffer.append(TEXT_658);
    }
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_659);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_660);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_661);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_662);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_663);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_664);
    }
    stringBuffer.append(TEXT_665);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_666);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_667);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_668);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_669);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); // DDDD
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_670);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_671);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_672);
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_673);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_674);
    }
    stringBuffer.append(TEXT_675);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_676);
    }
    stringBuffer.append(TEXT_677);
    } else {
    stringBuffer.append(TEXT_678);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_679);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_680);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_681);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_682);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_683);
    }
    stringBuffer.append(TEXT_684);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_685);
    }
    stringBuffer.append(TEXT_686);
    }
    } else {
    stringBuffer.append(TEXT_687);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_688);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_689);
    //Class/setGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_690);
    }
    //Class/setGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
    stringBuffer.append(TEXT_691);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_692);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_693);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_694);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_695);
    } else {
    stringBuffer.append(TEXT_696);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_697);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_698);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_699);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_700);
    }
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_701);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_702);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_703);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_704);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_705);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_706);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_707);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_708);
    } else {
    stringBuffer.append(TEXT_709);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_710);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_711);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_712);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_713);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_714);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_715);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_716);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_717);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_718);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_719);
    } else {
    stringBuffer.append(TEXT_720);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_721);
    }
    stringBuffer.append(TEXT_722);
    } else {
    stringBuffer.append(TEXT_723);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_724);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_725);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_726);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_727);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_728);
    }
    stringBuffer.append(TEXT_729);
    }
    stringBuffer.append(TEXT_730);
    } else {
    stringBuffer.append(TEXT_731);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_732);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_733);
    //Class/basicUnsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_734);
    //Class.basicUnsetGenFeature.override.javajetinc
    }
    if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_735);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_736);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_737);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_738);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_739);
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_740);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_741);
    }
    stringBuffer.append(TEXT_742);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_743);
    if (!genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_744);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_745);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_746);
    }
    stringBuffer.append(TEXT_747);
    } else {
    stringBuffer.append(TEXT_748);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_749);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_750);
    } else {
    stringBuffer.append(TEXT_751);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_752);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_753);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_754);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    stringBuffer.append(TEXT_755);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_756);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_757);
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_758);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_759);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_760);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_761);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_762);
    }
    stringBuffer.append(TEXT_763);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_764);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_765);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_766);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_767);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_768);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_769);
    stringBuffer.append(SDOGenUtil.getQualifiedInternalPropertyID(reverseFeature));
    stringBuffer.append(TEXT_770);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_771);
    }
    stringBuffer.append(TEXT_772);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_773);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_774);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_775);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_776);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_777);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_778);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_779);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_780);
    }
    stringBuffer.append(TEXT_781);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_783);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_784);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_785);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_786);
    }
    stringBuffer.append(TEXT_787);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_788);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_789);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_790);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_791);
    }
    stringBuffer.append(TEXT_792);
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_793);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_794);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_795);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_797);
    }
    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_798);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_799);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_800);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_801);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_802);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_803);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_804);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_805);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_806);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_807);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_808);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_810);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_811);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_812);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_813);
    }
    }
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_814);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_815);
    if (!genModel.isVirtualDelegation()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_816);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_817);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_818);
    } else {
    stringBuffer.append(TEXT_819);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_820);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_821);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_822);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_823);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_824);
    } else {
    stringBuffer.append(TEXT_825);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_826);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_827);
    } else {
    stringBuffer.append(TEXT_828);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_829);
    }
    stringBuffer.append(TEXT_830);
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_831);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_832);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_833);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_834);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_835);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_836);
    } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_837);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_838);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_839);
    }
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_840);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_841);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_842);
    } else {
    stringBuffer.append(TEXT_843);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_844);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_845);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_846);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_847);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_848);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_849);
    } else {
    stringBuffer.append(TEXT_850);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_851);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_852);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_853);
    } else {
    stringBuffer.append(TEXT_854);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_855);
    }
    stringBuffer.append(TEXT_856);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //EEEE
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_857);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_858);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_859);
    } else {
    stringBuffer.append(TEXT_860);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_861);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_862);
    }
    } else {
    stringBuffer.append(TEXT_863);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_864);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_865);
    //Class/unsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_866);
    }
    //Class/unsetGenFeature.override.javajetinc
    }
    if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_867);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_868);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_869);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_870);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_871);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_872);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_873);
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_874);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_875);
    }
    stringBuffer.append(TEXT_876);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_877);
    if (!genFeature.isListType() && genFeature.isChangeable() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_878);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_879);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_880);
    }
    stringBuffer.append(TEXT_881);
    } else {
    stringBuffer.append(TEXT_882);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_883);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_884);
    } else {
    stringBuffer.append(TEXT_885);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_886);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_887);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_888);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_889);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_890);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_891);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_892);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_893);
    }
    stringBuffer.append(TEXT_894);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_895);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_896);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_897);
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_898);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_899);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_900);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_901);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_902);
    } else {
    stringBuffer.append(TEXT_903);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_904);
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature(); //FFFF
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_905);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_906);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_907);
    } else {
    stringBuffer.append(TEXT_908);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_909);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_911);
    }
    } else {
    stringBuffer.append(TEXT_912);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_913);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_914);
    //Class/isSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_915);
    }
    //Class/isSetGenFeature.override.javajetinc
    }
    //Class/genFeature.override.javajetinc
    }// end output getter and setter interfaces or impls
    for (Iterator i= (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations()).iterator(); i.hasNext();) { GenOperation genOperation = (GenOperation)i.next();
    if (isInterface) {
    stringBuffer.append(TEXT_916);
    if (genOperation.hasDocumentation()) {
    stringBuffer.append(TEXT_917);
    stringBuffer.append(genOperation.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_918);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genOperation.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_919);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_920);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_921);
    }}
    stringBuffer.append(TEXT_922);
    } else {
    stringBuffer.append(TEXT_923);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_924);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_925);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_926);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_927);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_928);
    } else {
    stringBuffer.append(TEXT_929);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_930);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_931);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_932);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_933);
    if (genOperation.hasBody()) {
    stringBuffer.append(TEXT_934);
    stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
    } else if (genOperation.isInvariant()) {GenClass opClass = genOperation.getGenClass(); String diagnostics = ((GenParameter)genOperation.getGenParameters().get(0)).getName(); String context = ((GenParameter)genOperation.getGenParameters().get(1)).getName();
    stringBuffer.append(TEXT_935);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_936);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_937);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
    stringBuffer.append(TEXT_939);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_940);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_941);
    stringBuffer.append(opClass.getOperationID(genOperation));
    stringBuffer.append(TEXT_942);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
    stringBuffer.append(TEXT_943);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_944);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
    stringBuffer.append(TEXT_945);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_946);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_947);
    } else {
    stringBuffer.append(TEXT_948);
    //Class/implementedGenOperation.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_949);
    }
    //Class/implementedGenOperation.override.javajetinc
    }//for
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
    stringBuffer.append(TEXT_950);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_951);
    for (Iterator i=genClass.getEInverseAddGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_952);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_953);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_954);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_955);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_957);
    } else {
    stringBuffer.append(TEXT_958);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_959);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_960);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_961);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_962);
    } else {
    if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_963);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_964);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_965);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_966);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_967);
    }
    stringBuffer.append(TEXT_968);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_969);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_970);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_972);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_973);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_974);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_975);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_976);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_977);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_978);
    }
    stringBuffer.append(TEXT_979);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_980);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_981);
    }
    }
    }
    stringBuffer.append(TEXT_982);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_983);
    } else {
    stringBuffer.append(TEXT_984);
    }
    stringBuffer.append(TEXT_985);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
    stringBuffer.append(TEXT_986);
    stringBuffer.append(genModel.getImportedName("java.lang.Object"));
    stringBuffer.append(TEXT_987);
    for (Iterator i=genClass.getEInverseRemoveGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_988);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_989);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_990);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_992);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_993);
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_994);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_995);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_996);
    } else {
    stringBuffer.append(TEXT_997);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_998);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_999);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1000);
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1002);
    } else {
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1004);
    }
    }
    }
    stringBuffer.append(TEXT_1005);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1006);
    } else {
    stringBuffer.append(TEXT_1007);
    }
    stringBuffer.append(TEXT_1008);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
    stringBuffer.append(TEXT_1009);
    for (Iterator i=genClass.getEBasicRemoveFromContainerGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1013);
    }
    }
    stringBuffer.append(TEXT_1014);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1015);
    } else {
    stringBuffer.append(TEXT_1016);
    }
    stringBuffer.append(TEXT_1017);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1018);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1020);
    if (genFeature.isPrimitiveType()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1022);
    } else {
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1025);
    }
    } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1028);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1032);
    } else {
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1035);
    }
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1037);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1041);
    } else {
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1043);
    }
    }
    }
    stringBuffer.append(TEXT_1044);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1045);
    } else {
    stringBuffer.append(TEXT_1046);
    }
    stringBuffer.append(TEXT_1047);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
    stringBuffer.append(TEXT_1048);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1050);
    if (genFeature.isListType()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1053);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1056);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1060);
    } else {
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1063);
    }
    } else {
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1067);
    }
    } else if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1071);
    } else {
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1074);
    }
    stringBuffer.append(TEXT_1075);
    }
    }
    stringBuffer.append(TEXT_1076);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1077);
    } else {
    stringBuffer.append(TEXT_1078);
    }
    stringBuffer.append(TEXT_1079);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1081);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1084);
    } else {
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1086);
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1088);
    } else if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1091);
    } else {
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1094);
    }
    stringBuffer.append(TEXT_1095);
    }
    }
    stringBuffer.append(TEXT_1096);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1097);
    } else {
    stringBuffer.append(TEXT_1098);
    }
    stringBuffer.append(TEXT_1099);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1100);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1102);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1105);
    } else {
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1109);
    }
    } else {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1112);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1119);
    } else {
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1121);
    }
    }
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1123);
    } else if (genFeature.isResolveProxies()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1125);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1127);
    } else {
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1129);
    }
    }
    } else if (genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1131);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1133);
    } else {
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1135);
    }
    }
    } else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1139);
    } else {
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1142);
    }
    } else {
    if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1146);
    } else {
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1149);
    }
    }
    } else {//datatype
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1154);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1164);
    } else {
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1169);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1170);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1171);
    } else {
    stringBuffer.append(TEXT_1172);
    }
    stringBuffer.append(TEXT_1173);
    //Class/eIsSet.override.javajetinc
    }
    if (isImplementation && !genClass.getMixinGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1174);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1176);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1179);
    }
    stringBuffer.append(TEXT_1180);
    }
    stringBuffer.append(TEXT_1181);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1183);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1186);
    }
    stringBuffer.append(TEXT_1187);
    }
    stringBuffer.append(TEXT_1188);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1191);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) { List allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList());
    stringBuffer.append(TEXT_1192);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1195);
    }
    stringBuffer.append(TEXT_1196);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1199);
    }
    stringBuffer.append(TEXT_1200);
    }
    }
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1201);
    { boolean first = true;
    for (Iterator i=genClass.getToStringGenFeatures().iterator(); i.hasNext(); ) { GenFeature genFeature = (GenFeature)i.next();
    if (first) { first = false;
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.isUnsettable() && !genFeature.isListType()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1209);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1212);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1213);
    }
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1217);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1220);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1221);
    }
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isListType() && !genFeature.isReferenceType()){
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1226);
    }
    stringBuffer.append(TEXT_1227);
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1230);
    } else {
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1232);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1233);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.isAbstract()) {
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_1235);
    }
    if (isImplementation && genClass.isMapEntry()) { GenFeature keyFeature = genClass.getMapEntryKeyFeature(); GenFeature valueFeature = genClass.getMapEntryValueFeature();
    stringBuffer.append(TEXT_1236);
    if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1238);
    } else {
    stringBuffer.append(TEXT_1239);
    }
    stringBuffer.append(TEXT_1240);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1242);
    } else if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(keyFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1245);
    } else {
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(keyFeature.getImportedType());
    stringBuffer.append(TEXT_1247);
    }
    stringBuffer.append(TEXT_1248);
    if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1250);
    } else {
    stringBuffer.append(TEXT_1251);
    }
    stringBuffer.append(TEXT_1252);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1254);
    } else if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(valueFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1257);
    } else {
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(valueFeature.getImportedType());
    stringBuffer.append(TEXT_1259);
    }
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1263);
    }
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
    // TODO fix the space above
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_1265);
    return stringBuffer.toString();
  }
}
