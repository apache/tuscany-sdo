package org.apache.tuscany.sdo.generate.templates.model;

import org.eclipse.emf.codegen.util.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

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
  protected final String TEXT_11 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A representation of the model object '<em><b>";
  protected final String TEXT_12 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_13 = NL + " *" + NL + " * <!-- begin-model-doc -->" + NL + " * ";
  protected final String TEXT_14 = NL + " * <!-- end-model-doc -->";
  protected final String TEXT_15 = NL + " *";
  protected final String TEXT_16 = NL + " * <p>" + NL + " * The following features are supported:" + NL + " * <ul>";
  protected final String TEXT_17 = NL + " *   <li>{@link ";
  protected final String TEXT_18 = "#";
  protected final String TEXT_19 = " <em>";
  protected final String TEXT_20 = "</em>}</li>";
  protected final String TEXT_21 = NL + " * </ul>" + NL + " * </p>";
  protected final String TEXT_22 = NL + " *";
  protected final String TEXT_23 = NL + " * @see ";
  protected final String TEXT_24 = "#get";
  protected final String TEXT_25 = "()";
  protected final String TEXT_26 = NL + " * @model ";
  protected final String TEXT_27 = NL + " *        ";
  protected final String TEXT_28 = NL + " * @model";
  protected final String TEXT_29 = NL + " * @extends ";
  protected final String TEXT_30 = NL + " * @generated" + NL + " */";
  protected final String TEXT_31 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model object '<em><b>";
  protected final String TEXT_32 = "</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>";
  protected final String TEXT_33 = NL + " * The following features are implemented:" + NL + " * <ul>";
  protected final String TEXT_34 = NL + " *   <li>{@link ";
  protected final String TEXT_35 = "#";
  protected final String TEXT_36 = " <em>";
  protected final String TEXT_37 = "</em>}</li>";
  protected final String TEXT_38 = NL + " * </ul>";
  protected final String TEXT_39 = NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */";
  protected final String TEXT_40 = NL + "public";
  protected final String TEXT_41 = " abstract";
  protected final String TEXT_42 = " class ";
  protected final String TEXT_43 = NL + "public interface ";
  protected final String TEXT_44 = NL + "{";
  protected final String TEXT_45 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_46 = " copyright = \"";
  protected final String TEXT_47 = "\";";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_50 = " mofDriverNumber = \"";
  protected final String TEXT_51 = "\";";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL;
  protected final String TEXT_54 = NL + "\t/**" + NL + "\t * An array of objects representing the values of non-primitive features." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] ";
  protected final String TEXT_55 = " = null;" + NL;
  protected final String TEXT_56 = NL + "\t/**" + NL + "\t * A bit field representing the indices of non-primitive feature values." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_57 = " = 0;" + NL;
  protected final String TEXT_58 = NL + "\t/**" + NL + "\t * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_59 = " = 0;" + NL;
  protected final String TEXT_60 = NL + "\t/**" + NL + "\t * The feature id for the '<em><b>";
  protected final String TEXT_61 = "</b></em>' ";
  protected final String TEXT_62 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_63 = "\t " + NL + "\tpublic final static int ";
  protected final String TEXT_64 = " = ";
  protected final String TEXT_65 = ";" + NL;
  protected final String TEXT_66 = NL + "\t/**" + NL + "\t * This represents the number of properties for this type." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t";
  protected final String TEXT_67 = NL + "\tpublic final static int SDO_PROPERTY_COUNT = ";
  protected final String TEXT_68 = ";" + NL;
  protected final String TEXT_69 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_70 = "() <em>";
  protected final String TEXT_71 = "</em>}' ";
  protected final String TEXT_72 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_73 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\t" + NL + "\tprotected ";
  protected final String TEXT_74 = " ";
  protected final String TEXT_75 = " = null;" + NL + "\t";
  protected final String TEXT_76 = NL + "\t/**" + NL + "\t * The empty value for the '{@link #";
  protected final String TEXT_77 = "() <em>";
  protected final String TEXT_78 = "</em>}' array accessor." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_79 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_80 = "[] ";
  protected final String TEXT_81 = "_EEMPTY_ARRAY = new ";
  protected final String TEXT_82 = " [0];" + NL;
  protected final String TEXT_83 = NL + "\t/**" + NL + "\t * The default value of the '{@link #";
  protected final String TEXT_84 = "() <em>";
  protected final String TEXT_85 = "</em>}' ";
  protected final String TEXT_86 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_87 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_88 = " ";
  protected final String TEXT_89 = "_DEFAULT_ = ";
  protected final String TEXT_90 = ";";
  protected final String TEXT_91 = NL;
  protected final String TEXT_92 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_93 = " = 0;" + NL;
  protected final String TEXT_94 = NL + "\t/**" + NL + "\t * The flag representing the value of the '{@link #";
  protected final String TEXT_95 = "() <em>";
  protected final String TEXT_96 = "</em>}' ";
  protected final String TEXT_97 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_98 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_99 = "_EFLAG = 1 ";
  protected final String TEXT_100 = ";" + NL;
  protected final String TEXT_101 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_102 = "() <em>";
  protected final String TEXT_103 = "</em>}' ";
  protected final String TEXT_104 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_105 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_106 = " ";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = "_DEFAULT_;" + NL;
  protected final String TEXT_109 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_110 = " = 0;" + NL;
  protected final String TEXT_111 = NL + "\t/**" + NL + "\t * The flag representing whether the ";
  protected final String TEXT_112 = " ";
  protected final String TEXT_113 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_114 = "_ESETFLAG = 1 ";
  protected final String TEXT_115 = ";" + NL;
  protected final String TEXT_116 = NL + "\t/**" + NL + "\t * This is true if the ";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected boolean ";
  protected final String TEXT_119 = "_set_ = false;" + NL;
  protected final String TEXT_120 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_121 = "()" + NL + "\t{" + NL + "\t\tsuper();";
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = " |= ";
  protected final String TEXT_124 = "_EFLAG;";
  protected final String TEXT_125 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_126 = " getType()" + NL + "\t{" + NL + "\t\treturn ((";
  protected final String TEXT_127 = ")";
  protected final String TEXT_128 = ".INSTANCE).get";
  protected final String TEXT_129 = "();" + NL + "\t}" + NL;
  protected final String TEXT_130 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_131 = NL + "\t";
  protected final String TEXT_132 = "[] ";
  protected final String TEXT_133 = "();" + NL;
  protected final String TEXT_134 = NL + "\tpublic ";
  protected final String TEXT_135 = "[] ";
  protected final String TEXT_136 = "()" + NL + "\t{";
  protected final String TEXT_137 = NL + "\t\t";
  protected final String TEXT_138 = " list = (";
  protected final String TEXT_139 = ")";
  protected final String TEXT_140 = "();" + NL + "\t\tif (list.isEmpty()) return ";
  protected final String TEXT_141 = "_EEMPTY_ARRAY;";
  protected final String TEXT_142 = NL + "\t\tif (";
  protected final String TEXT_143 = " == null || ";
  protected final String TEXT_144 = ".isEmpty()) return ";
  protected final String TEXT_145 = "_EEMPTY_ARRAY;" + NL + "\t\t";
  protected final String TEXT_146 = " list = (";
  protected final String TEXT_147 = ")";
  protected final String TEXT_148 = ";";
  protected final String TEXT_149 = NL + "\t\tlist.shrink();" + NL + "\t\treturn (";
  protected final String TEXT_150 = "[])list.data();" + NL + "\t}" + NL;
  protected final String TEXT_151 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_152 = NL + "\t";
  protected final String TEXT_153 = " get";
  protected final String TEXT_154 = "(int index);";
  protected final String TEXT_155 = NL + "\tpublic ";
  protected final String TEXT_156 = " get";
  protected final String TEXT_157 = "(int index)" + NL + "\t{" + NL + "\t\treturn (";
  protected final String TEXT_158 = ")";
  protected final String TEXT_159 = "().get(index);" + NL + "\t}";
  protected final String TEXT_160 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_161 = NL + "\tint get";
  protected final String TEXT_162 = "Length();" + NL;
  protected final String TEXT_163 = NL + "\tpublic int get";
  protected final String TEXT_164 = "Length()" + NL + "\t{";
  protected final String TEXT_165 = NL + "\t\treturn ";
  protected final String TEXT_166 = "().size();";
  protected final String TEXT_167 = NL + "\t\treturn ";
  protected final String TEXT_168 = " == null ? 0 : ";
  protected final String TEXT_169 = ".size();";
  protected final String TEXT_170 = NL + "\t}" + NL;
  protected final String TEXT_171 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_172 = NL + "\tvoid set";
  protected final String TEXT_173 = "(";
  protected final String TEXT_174 = "[] new";
  protected final String TEXT_175 = ");" + NL;
  protected final String TEXT_176 = NL + "\tpublic void set";
  protected final String TEXT_177 = "(";
  protected final String TEXT_178 = "[] new";
  protected final String TEXT_179 = ")" + NL + "\t{" + NL + "\t\t((";
  protected final String TEXT_180 = ")";
  protected final String TEXT_181 = "()).setData(new";
  protected final String TEXT_182 = ".length, new";
  protected final String TEXT_183 = ");" + NL + "\t}" + NL;
  protected final String TEXT_184 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_185 = NL + "\tvoid set";
  protected final String TEXT_186 = "(int index, ";
  protected final String TEXT_187 = " element);" + NL;
  protected final String TEXT_188 = NL + "\tpublic void set";
  protected final String TEXT_189 = "(int index, ";
  protected final String TEXT_190 = " element)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_191 = "().set(index, element);" + NL + "\t}" + NL;
  protected final String TEXT_192 = NL + "\t/**" + NL + "\t * Returns the value of the '<em><b>";
  protected final String TEXT_193 = "</b></em>' ";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = NL + "\t * The key is of type ";
  protected final String TEXT_196 = "list of {@link ";
  protected final String TEXT_197 = "}";
  protected final String TEXT_198 = "{@link ";
  protected final String TEXT_199 = "}";
  protected final String TEXT_200 = "," + NL + "\t * and the value is of type ";
  protected final String TEXT_201 = "list of {@link ";
  protected final String TEXT_202 = "}";
  protected final String TEXT_203 = "{@link ";
  protected final String TEXT_204 = "}";
  protected final String TEXT_205 = ",";
  protected final String TEXT_206 = NL + "\t * The list contents are of type {@link ";
  protected final String TEXT_207 = "}.";
  protected final String TEXT_208 = NL + "\t * The default value is <code>";
  protected final String TEXT_209 = "</code>.";
  protected final String TEXT_210 = NL + "\t * The literals are from the enumeration {@link ";
  protected final String TEXT_211 = "}.";
  protected final String TEXT_212 = NL + "\t * It is bidirectional and its opposite is '{@link ";
  protected final String TEXT_213 = "#";
  protected final String TEXT_214 = " <em>";
  protected final String TEXT_215 = "</em>}'.";
  protected final String TEXT_216 = NL + "\t * <!-- begin-user-doc -->";
  protected final String TEXT_217 = NL + "\t * <p>" + NL + "\t * If the meaning of the '<em>";
  protected final String TEXT_218 = "</em>' ";
  protected final String TEXT_219 = " isn't clear," + NL + "\t * there really should be more of a description here..." + NL + "\t * </p>";
  protected final String TEXT_220 = NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_221 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_222 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_223 = NL + "\t * @return the value of the '<em>";
  protected final String TEXT_224 = "</em>' ";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = NL + "\t * @see ";
  protected final String TEXT_227 = NL + "\t * @see #isSet";
  protected final String TEXT_228 = "()";
  protected final String TEXT_229 = NL + "\t * @see #unset";
  protected final String TEXT_230 = "()";
  protected final String TEXT_231 = NL + "\t * @see #set";
  protected final String TEXT_232 = "(";
  protected final String TEXT_233 = ")";
  protected final String TEXT_234 = NL + "\t * @see ";
  protected final String TEXT_235 = "#get";
  protected final String TEXT_236 = "()";
  protected final String TEXT_237 = NL + "\t * @see ";
  protected final String TEXT_238 = "#";
  protected final String TEXT_239 = NL + "\t * @model ";
  protected final String TEXT_240 = NL + "\t *        ";
  protected final String TEXT_241 = NL + "\t * @model";
  protected final String TEXT_242 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_243 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_244 = NL + "\t";
  protected final String TEXT_245 = " ";
  protected final String TEXT_246 = "();" + NL;
  protected final String TEXT_247 = NL + "\tpublic ";
  protected final String TEXT_248 = " ";
  protected final String TEXT_249 = "()" + NL + "\t{";
  protected final String TEXT_250 = NL + "\t\treturn ";
  protected final String TEXT_251 = "(";
  protected final String TEXT_252 = "(";
  protected final String TEXT_253 = ")get(";
  protected final String TEXT_254 = ", true)";
  protected final String TEXT_255 = ").";
  protected final String TEXT_256 = "()";
  protected final String TEXT_257 = ";";
  protected final String TEXT_258 = NL + "\t\t";
  protected final String TEXT_259 = " ";
  protected final String TEXT_260 = " = (";
  protected final String TEXT_261 = ")eVirtualGet(";
  protected final String TEXT_262 = ");";
  protected final String TEXT_263 = NL + "\t\tif (";
  protected final String TEXT_264 = " == null)" + NL + "\t\t{";
  protected final String TEXT_265 = NL + "\t\t\teVirtualSet(";
  protected final String TEXT_266 = ", ";
  protected final String TEXT_267 = " = new ";
  protected final String TEXT_268 = ");";
  protected final String TEXT_269 = NL + "\t\t  ";
  protected final String TEXT_270 = " = createSequence(";
  protected final String TEXT_271 = ");";
  protected final String TEXT_272 = NL + "\t\t  ";
  protected final String TEXT_273 = " = createPropertyList(ListKind.CONTAINMENT, ";
  protected final String TEXT_274 = ".class, ";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_277 = ";";
  protected final String TEXT_278 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_279 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_280 = ")eContainer();";
  protected final String TEXT_281 = NL + "\t\t";
  protected final String TEXT_282 = " ";
  protected final String TEXT_283 = " = (";
  protected final String TEXT_284 = ")eVirtualGet(";
  protected final String TEXT_285 = ", ";
  protected final String TEXT_286 = "_DEFAULT_";
  protected final String TEXT_287 = ");";
  protected final String TEXT_288 = NL + "\t\tif (";
  protected final String TEXT_289 = " != null && ";
  protected final String TEXT_290 = ".isProxy())" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_291 = " old";
  protected final String TEXT_292 = " = (";
  protected final String TEXT_293 = ")";
  protected final String TEXT_294 = ";" + NL + "\t\t\t";
  protected final String TEXT_295 = " = ";
  protected final String TEXT_296 = "eResolveProxy(old";
  protected final String TEXT_297 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_298 = " != old";
  protected final String TEXT_299 = ")" + NL + "\t\t\t{";
  protected final String TEXT_300 = NL + "\t\t\t\t";
  protected final String TEXT_301 = " new";
  protected final String TEXT_302 = " = (";
  protected final String TEXT_303 = ")";
  protected final String TEXT_304 = ";";
  protected final String TEXT_305 = NL + "\t\t\t\tChangeContext changeContext = old";
  protected final String TEXT_306 = ".inverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_307 = ", null, null);";
  protected final String TEXT_308 = NL + "\t\t\t\t";
  protected final String TEXT_309 = " changeContext =  old";
  protected final String TEXT_310 = ".inverseRemove(this, ";
  protected final String TEXT_311 = ", ";
  protected final String TEXT_312 = ".class, null);";
  protected final String TEXT_313 = NL + "\t\t\t\tif (new";
  protected final String TEXT_314 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
  protected final String TEXT_315 = NL + "\t\t\t\t\tchangeContext = new";
  protected final String TEXT_316 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_317 = ", null, changeContext);";
  protected final String TEXT_318 = NL + "\t\t\t\t\tchangeContext =  new";
  protected final String TEXT_319 = ".eInverseAdd(this, ";
  protected final String TEXT_320 = ", ";
  protected final String TEXT_321 = ".class, changeContext);";
  protected final String TEXT_322 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (changeContext != null) dispatch(changeContext);";
  protected final String TEXT_323 = NL + "\t\t\t\teVirtualSet(";
  protected final String TEXT_324 = ", ";
  protected final String TEXT_325 = ");";
  protected final String TEXT_326 = NL + "\t\t\t\tif (isNotifying())" + NL + "\t\t\t\t\tnotify(ChangeKind.RESOLVE, ";
  protected final String TEXT_327 = ", old";
  protected final String TEXT_328 = ", ";
  protected final String TEXT_329 = ");";
  protected final String TEXT_330 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_331 = NL + "\t\treturn (";
  protected final String TEXT_332 = ")eVirtualGet(";
  protected final String TEXT_333 = ", ";
  protected final String TEXT_334 = "_DEFAULT_";
  protected final String TEXT_335 = ");";
  protected final String TEXT_336 = NL + "\t\treturn (";
  protected final String TEXT_337 = " & ";
  protected final String TEXT_338 = "_EFLAG) != 0;";
  protected final String TEXT_339 = NL + "\t\treturn ";
  protected final String TEXT_340 = ";";
  protected final String TEXT_341 = NL + "\t\t";
  protected final String TEXT_342 = " ";
  protected final String TEXT_343 = " = basicGet";
  protected final String TEXT_344 = "();" + NL + "\t\treturn ";
  protected final String TEXT_345 = " != null && ";
  protected final String TEXT_346 = ".isProxy() ? ";
  protected final String TEXT_347 = "eResolveProxy((";
  protected final String TEXT_348 = ")";
  protected final String TEXT_349 = ") : ";
  protected final String TEXT_350 = ";";
  protected final String TEXT_351 = NL + "\t\treturn create";
  protected final String TEXT_352 = "(get";
  protected final String TEXT_353 = "(), getType(), ";
  protected final String TEXT_354 = ");";
  protected final String TEXT_355 = NL + "\t\treturn (";
  protected final String TEXT_356 = ")((";
  protected final String TEXT_357 = ")get";
  protected final String TEXT_358 = "()).list(";
  protected final String TEXT_359 = ");";
  protected final String TEXT_360 = NL + "          return get";
  protected final String TEXT_361 = "(get";
  protected final String TEXT_362 = "(), getType(), ";
  protected final String TEXT_363 = ");" + NL;
  protected final String TEXT_364 = NL + "\t\treturn ((";
  protected final String TEXT_365 = ")get";
  protected final String TEXT_366 = "()).list(";
  protected final String TEXT_367 = ");";
  protected final String TEXT_368 = NL + "\t\treturn ";
  protected final String TEXT_369 = "(";
  protected final String TEXT_370 = "(";
  protected final String TEXT_371 = ")get(get";
  protected final String TEXT_372 = "(), getType(), ";
  protected final String TEXT_373 = ")";
  protected final String TEXT_374 = ").";
  protected final String TEXT_375 = "()";
  protected final String TEXT_376 = ";";
  protected final String TEXT_377 = NL + "\t\treturn ";
  protected final String TEXT_378 = "(";
  protected final String TEXT_379 = "(";
  protected final String TEXT_380 = ")get(get";
  protected final String TEXT_381 = "(), getType(), ";
  protected final String TEXT_382 = ");";
  protected final String TEXT_383 = ").";
  protected final String TEXT_384 = "()";
  protected final String TEXT_385 = ";";
  protected final String TEXT_386 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_387 = "' ";
  protected final String TEXT_388 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_389 = NL + "\t}";
  protected final String TEXT_390 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_391 = " basicGet";
  protected final String TEXT_392 = "()" + NL + "\t{";
  protected final String TEXT_393 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_394 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_395 = ")eInternalContainer();";
  protected final String TEXT_396 = NL + "\t\treturn (";
  protected final String TEXT_397 = ")eVirtualGet(";
  protected final String TEXT_398 = ");";
  protected final String TEXT_399 = NL + "\t\treturn ";
  protected final String TEXT_400 = ";";
  protected final String TEXT_401 = NL + "\t\treturn (";
  protected final String TEXT_402 = ")get(get";
  protected final String TEXT_403 = "(), getType(), ";
  protected final String TEXT_404 = ");";
  protected final String TEXT_405 = NL + "\t\treturn (";
  protected final String TEXT_406 = ")get";
  protected final String TEXT_407 = "().get(";
  protected final String TEXT_408 = ", false);";
  protected final String TEXT_409 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_410 = "' ";
  protected final String TEXT_411 = NL + "\t\t// -> do not perform proxy resolution" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_412 = NL + "\t}" + NL;
  protected final String TEXT_413 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicSet";
  protected final String TEXT_414 = "(";
  protected final String TEXT_415 = " new";
  protected final String TEXT_416 = ", ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_417 = NL + "\t\tObject old";
  protected final String TEXT_418 = " = eVirtualSet(";
  protected final String TEXT_419 = ", new";
  protected final String TEXT_420 = ");";
  protected final String TEXT_421 = NL + "\t\t";
  protected final String TEXT_422 = " old";
  protected final String TEXT_423 = " = ";
  protected final String TEXT_424 = ";" + NL + "\t\t";
  protected final String TEXT_425 = " = new";
  protected final String TEXT_426 = ";";
  protected final String TEXT_427 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_428 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_429 = NL + "\t\tboolean old";
  protected final String TEXT_430 = "_set_ = (";
  protected final String TEXT_431 = " & ";
  protected final String TEXT_432 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_433 = " |= ";
  protected final String TEXT_434 = "_ESETFLAG;";
  protected final String TEXT_435 = NL + "\t\tboolean old";
  protected final String TEXT_436 = "_set_ = ";
  protected final String TEXT_437 = "_set_;" + NL + "\t\t";
  protected final String TEXT_438 = "_set_ = true;";
  protected final String TEXT_439 = NL + "\t\tif (isNotifying())" + NL + "\t\t{";
  protected final String TEXT_440 = NL + "\t\t\taddNotification(this, ChangeKind.SET, ";
  protected final String TEXT_441 = ", ";
  protected final String TEXT_442 = "isSetChange ? null : old";
  protected final String TEXT_443 = "old";
  protected final String TEXT_444 = ", new";
  protected final String TEXT_445 = ", ";
  protected final String TEXT_446 = "isSetChange";
  protected final String TEXT_447 = "!old";
  protected final String TEXT_448 = "_set_";
  protected final String TEXT_449 = ", changeContext);";
  protected final String TEXT_450 = NL + "\t\t\taddNotification(this, ChangeKind.SET, ";
  protected final String TEXT_451 = ", ";
  protected final String TEXT_452 = "old";
  protected final String TEXT_453 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_454 = "old";
  protected final String TEXT_455 = ", new";
  protected final String TEXT_456 = ", changeContext);";
  protected final String TEXT_457 = NL + "\t\t}";
  protected final String TEXT_458 = NL + "\t\treturn changeContext;";
  protected final String TEXT_459 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_460 = "(), getType(), ";
  protected final String TEXT_461 = ", new";
  protected final String TEXT_462 = ", changeContext);";
  protected final String TEXT_463 = NL + "\t\treturn basicAdd(get";
  protected final String TEXT_464 = "(), getType(), ";
  protected final String TEXT_465 = ", new";
  protected final String TEXT_466 = ", changeContext);";
  protected final String TEXT_467 = NL + "\t\t// TODO: implement this method to set the contained '";
  protected final String TEXT_468 = "' ";
  protected final String TEXT_469 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_470 = NL + "\t}" + NL;
  protected final String TEXT_471 = NL + "\t/**" + NL + "\t * Sets the value of the '{@link ";
  protected final String TEXT_472 = "#";
  protected final String TEXT_473 = " <em>";
  protected final String TEXT_474 = "</em>}' ";
  protected final String TEXT_475 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param value the new value of the '<em>";
  protected final String TEXT_476 = "</em>' ";
  protected final String TEXT_477 = ".";
  protected final String TEXT_478 = NL + "\t * @see ";
  protected final String TEXT_479 = NL + "\t * @see #isSet";
  protected final String TEXT_480 = "()";
  protected final String TEXT_481 = NL + "\t * @see #unset";
  protected final String TEXT_482 = "()";
  protected final String TEXT_483 = NL + "\t * @see #";
  protected final String TEXT_484 = "()" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_485 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_486 = NL + "\tvoid set";
  protected final String TEXT_487 = "(";
  protected final String TEXT_488 = " value);" + NL;
  protected final String TEXT_489 = NL + "\tpublic void set";
  protected final String TEXT_490 = "(";
  protected final String TEXT_491 = " new";
  protected final String TEXT_492 = ")" + NL + "\t{";
  protected final String TEXT_493 = NL + "\t\t_set_(";
  protected final String TEXT_494 = ", ";
  protected final String TEXT_495 = "new ";
  protected final String TEXT_496 = "(";
  protected final String TEXT_497 = "new";
  protected final String TEXT_498 = ")";
  protected final String TEXT_499 = ");";
  protected final String TEXT_500 = NL + "\t\tif (new";
  protected final String TEXT_501 = " != eInternalContainer() || (eContainerFeatureID != ";
  protected final String TEXT_502 = " && new";
  protected final String TEXT_503 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_504 = ".isAncestor(this, ";
  protected final String TEXT_505 = "new";
  protected final String TEXT_506 = "))" + NL + "\t\t\t\tthrow new ";
  protected final String TEXT_507 = "(\"Recursive containment not allowed for \" + toString());";
  protected final String TEXT_508 = NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_509 = " != null)" + NL + "\t\t\t\tchangeContext = ((";
  protected final String TEXT_510 = ")new";
  protected final String TEXT_511 = ").eInverseAdd(this, ";
  protected final String TEXT_512 = ", ";
  protected final String TEXT_513 = ".class, changeContext);" + NL + "\t\t\tchangeContext = eBasicSetContainer((";
  protected final String TEXT_514 = ")new";
  protected final String TEXT_515 = ", ";
  protected final String TEXT_516 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_517 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_518 = ", new";
  protected final String TEXT_519 = ", new";
  protected final String TEXT_520 = ");";
  protected final String TEXT_521 = NL + "\t\t";
  protected final String TEXT_522 = " ";
  protected final String TEXT_523 = " = (";
  protected final String TEXT_524 = ")eVirtualGet(";
  protected final String TEXT_525 = ");";
  protected final String TEXT_526 = NL + "\t\tif (new";
  protected final String TEXT_527 = " != ";
  protected final String TEXT_528 = ")" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;" + NL + "\t\t\tif (";
  protected final String TEXT_529 = " != null)";
  protected final String TEXT_530 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_531 = ", this, OPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_532 = ", null, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_533 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_534 = ", this, OPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_535 = ", null, changeContext);";
  protected final String TEXT_536 = NL + "\t\t\t\tchangeContext = inverseRemove(";
  protected final String TEXT_537 = ", this, ";
  protected final String TEXT_538 = ", ";
  protected final String TEXT_539 = ".class, changeContext);" + NL + "\t\t\tif (new";
  protected final String TEXT_540 = " != null)" + NL + "\t\t\t\tchangeContext = inverseAdd(new";
  protected final String TEXT_541 = ", this, ";
  protected final String TEXT_542 = ", ";
  protected final String TEXT_543 = ".class, changeContext);";
  protected final String TEXT_544 = NL + "\t\t\tchangeContext = basicSet";
  protected final String TEXT_545 = "(";
  protected final String TEXT_546 = "new";
  protected final String TEXT_547 = ", changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}";
  protected final String TEXT_548 = NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_549 = NL + "\t\t\tboolean old";
  protected final String TEXT_550 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_551 = ");";
  protected final String TEXT_552 = NL + "\t\t\tboolean old";
  protected final String TEXT_553 = "_set_ = (";
  protected final String TEXT_554 = " & ";
  protected final String TEXT_555 = "_ESETFLAG) != 0;";
  protected final String TEXT_556 = NL + "\t\t\t";
  protected final String TEXT_557 = " |= ";
  protected final String TEXT_558 = "_ESETFLAG;";
  protected final String TEXT_559 = NL + "\t\t\tboolean old";
  protected final String TEXT_560 = "_set_ = ";
  protected final String TEXT_561 = "_set_;";
  protected final String TEXT_562 = NL + "\t\t\t";
  protected final String TEXT_563 = "_set_ = true;";
  protected final String TEXT_564 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_565 = ", new";
  protected final String TEXT_566 = ", new";
  protected final String TEXT_567 = ", !old";
  protected final String TEXT_568 = "_set_);";
  protected final String TEXT_569 = NL + "    \t}";
  protected final String TEXT_570 = NL + "\t\telse if (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_571 = ", new";
  protected final String TEXT_572 = ", new";
  protected final String TEXT_573 = ");";
  protected final String TEXT_574 = NL + "\t\t";
  protected final String TEXT_575 = " old";
  protected final String TEXT_576 = " = (";
  protected final String TEXT_577 = " & ";
  protected final String TEXT_578 = "_EFLAG) != 0;";
  protected final String TEXT_579 = NL + "\t\tif (new";
  protected final String TEXT_580 = ") ";
  protected final String TEXT_581 = " |= ";
  protected final String TEXT_582 = "_EFLAG; else ";
  protected final String TEXT_583 = " &= ~";
  protected final String TEXT_584 = "_EFLAG;";
  protected final String TEXT_585 = NL + "\t\t";
  protected final String TEXT_586 = " old";
  protected final String TEXT_587 = " = ";
  protected final String TEXT_588 = ";";
  protected final String TEXT_589 = NL + "\t\t";
  protected final String TEXT_590 = " ";
  protected final String TEXT_591 = " = new";
  protected final String TEXT_592 = " == null ? ";
  protected final String TEXT_593 = "_DEFAULT_ : new";
  protected final String TEXT_594 = ";";
  protected final String TEXT_595 = NL + "\t\t";
  protected final String TEXT_596 = " = new";
  protected final String TEXT_597 = " == null ? ";
  protected final String TEXT_598 = "_DEFAULT_ : new";
  protected final String TEXT_599 = ";";
  protected final String TEXT_600 = NL + "\t\t";
  protected final String TEXT_601 = " ";
  protected final String TEXT_602 = " = ";
  protected final String TEXT_603 = "new";
  protected final String TEXT_604 = ";";
  protected final String TEXT_605 = NL + "\t\t";
  protected final String TEXT_606 = " = ";
  protected final String TEXT_607 = "new";
  protected final String TEXT_608 = ";";
  protected final String TEXT_609 = NL + "\t\tObject old";
  protected final String TEXT_610 = " = eVirtualSet(";
  protected final String TEXT_611 = ", ";
  protected final String TEXT_612 = ");";
  protected final String TEXT_613 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_614 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_615 = NL + "\t\tboolean old";
  protected final String TEXT_616 = "_set_ = (";
  protected final String TEXT_617 = " & ";
  protected final String TEXT_618 = "_ESETFLAG) != 0;";
  protected final String TEXT_619 = NL + "\t\t";
  protected final String TEXT_620 = " |= ";
  protected final String TEXT_621 = "_ESETFLAG;";
  protected final String TEXT_622 = NL + "\t\tboolean old";
  protected final String TEXT_623 = "_set_ = ";
  protected final String TEXT_624 = "_set_;";
  protected final String TEXT_625 = NL + "\t\t";
  protected final String TEXT_626 = "_set_ = true;";
  protected final String TEXT_627 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_628 = ", ";
  protected final String TEXT_629 = "isSetChange ? ";
  protected final String TEXT_630 = "null";
  protected final String TEXT_631 = "_DEFAULT_";
  protected final String TEXT_632 = " : old";
  protected final String TEXT_633 = "old";
  protected final String TEXT_634 = ", ";
  protected final String TEXT_635 = "new";
  protected final String TEXT_636 = ", ";
  protected final String TEXT_637 = "isSetChange";
  protected final String TEXT_638 = "!old";
  protected final String TEXT_639 = "_set_";
  protected final String TEXT_640 = ");";
  protected final String TEXT_641 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.SET, ";
  protected final String TEXT_642 = ", ";
  protected final String TEXT_643 = "old";
  protected final String TEXT_644 = " == EVIRTUAL_NO_VALUE ? ";
  protected final String TEXT_645 = "null";
  protected final String TEXT_646 = "_DEFAULT_";
  protected final String TEXT_647 = " : old";
  protected final String TEXT_648 = "old";
  protected final String TEXT_649 = ", ";
  protected final String TEXT_650 = "new";
  protected final String TEXT_651 = ");";
  protected final String TEXT_652 = NL + "\t\tset(get";
  protected final String TEXT_653 = "(), getType(), ";
  protected final String TEXT_654 = ", ";
  protected final String TEXT_655 = " new ";
  protected final String TEXT_656 = "(";
  protected final String TEXT_657 = "new";
  protected final String TEXT_658 = ")";
  protected final String TEXT_659 = ");";
  protected final String TEXT_660 = NL + "\t\t((";
  protected final String TEXT_661 = ".Internal)get";
  protected final String TEXT_662 = "()).set(";
  protected final String TEXT_663 = ", ";
  protected final String TEXT_664 = "new ";
  protected final String TEXT_665 = "(";
  protected final String TEXT_666 = "new";
  protected final String TEXT_667 = ")";
  protected final String TEXT_668 = ");";
  protected final String TEXT_669 = NL + "\t\t// TODO: implement this method to set the '";
  protected final String TEXT_670 = "' ";
  protected final String TEXT_671 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_672 = NL + "\t}" + NL;
  protected final String TEXT_673 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext basicUnset";
  protected final String TEXT_674 = "(ChangeContext changeContext)" + NL + "\t{";
  protected final String TEXT_675 = NL + "\t\tObject old";
  protected final String TEXT_676 = " = eVirtualUnset(";
  protected final String TEXT_677 = ");";
  protected final String TEXT_678 = NL + "\t\t";
  protected final String TEXT_679 = " old";
  protected final String TEXT_680 = " = ";
  protected final String TEXT_681 = ";" + NL + "\t\t";
  protected final String TEXT_682 = " = null;";
  protected final String TEXT_683 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_684 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_685 = NL + "\t\tboolean old";
  protected final String TEXT_686 = "_set_ = (";
  protected final String TEXT_687 = " & ";
  protected final String TEXT_688 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_689 = " &= ~";
  protected final String TEXT_690 = "_ESETFLAG;";
  protected final String TEXT_691 = NL + "\t\tboolean old";
  protected final String TEXT_692 = "_set_ = ";
  protected final String TEXT_693 = "_set_;" + NL + "\t\t";
  protected final String TEXT_694 = "_set_ = false;";
  protected final String TEXT_695 = NL + "\t\tif (isNotifying())" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_696 = " notification = new ";
  protected final String TEXT_697 = "(this, ";
  protected final String TEXT_698 = ".UNSET, ";
  protected final String TEXT_699 = ", ";
  protected final String TEXT_700 = "isSetChange ? old";
  protected final String TEXT_701 = " : null";
  protected final String TEXT_702 = "old";
  protected final String TEXT_703 = ", null, ";
  protected final String TEXT_704 = "isSetChange";
  protected final String TEXT_705 = "old";
  protected final String TEXT_706 = "_set_";
  protected final String TEXT_707 = ");" + NL + "\t\t\tif (changeContext == null) changeContext = notification; else changeContext.add(notification);" + NL + "\t\t}" + NL + "\t\treturn changeContext;";
  protected final String TEXT_708 = NL + "\t\t// TODO: implement this method to unset the contained '";
  protected final String TEXT_709 = "' ";
  protected final String TEXT_710 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return changeContext, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_711 = NL + "\t}" + NL;
  protected final String TEXT_712 = NL + "\t/**" + NL + "\t * Unsets the value of the '{@link ";
  protected final String TEXT_713 = "#";
  protected final String TEXT_714 = " <em>";
  protected final String TEXT_715 = "</em>}' ";
  protected final String TEXT_716 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_717 = NL + "\t * @see #isSet";
  protected final String TEXT_718 = "()";
  protected final String TEXT_719 = NL + "\t * @see #";
  protected final String TEXT_720 = "()";
  protected final String TEXT_721 = NL + "\t * @see #set";
  protected final String TEXT_722 = "(";
  protected final String TEXT_723 = ")";
  protected final String TEXT_724 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_725 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_726 = NL + "\tvoid unset";
  protected final String TEXT_727 = "();" + NL;
  protected final String TEXT_728 = NL + "\tpublic void unset";
  protected final String TEXT_729 = "()" + NL + "\t{";
  protected final String TEXT_730 = NL + "\t\tunset(";
  protected final String TEXT_731 = ");";
  protected final String TEXT_732 = NL + "\t\t((";
  protected final String TEXT_733 = ".Unsettable)get";
  protected final String TEXT_734 = "()).unset();";
  protected final String TEXT_735 = NL + "\t\t";
  protected final String TEXT_736 = " ";
  protected final String TEXT_737 = " = (";
  protected final String TEXT_738 = ")eVirtualGet(";
  protected final String TEXT_739 = ");";
  protected final String TEXT_740 = NL + "\t\tif (";
  protected final String TEXT_741 = " != null)" + NL + "\t\t{" + NL + "\t\t\tChangeContext changeContext = null;";
  protected final String TEXT_742 = NL + "\t\t\tchangeContext = ((";
  protected final String TEXT_743 = ")";
  protected final String TEXT_744 = ").inverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_745 = ", null, changeContext);";
  protected final String TEXT_746 = NL + "\t\t\tchangeContext = ((";
  protected final String TEXT_747 = ")";
  protected final String TEXT_748 = ").inverseRemove(this, ";
  protected final String TEXT_749 = ", ";
  protected final String TEXT_750 = ".class, changeContext);";
  protected final String TEXT_751 = NL + "\t\t\tchangeContext = basicUnset";
  protected final String TEXT_752 = "(changeContext);" + NL + "\t\t\tif (changeContext != null) dispatch(changeContext);" + NL + "\t\t}" + NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_753 = NL + "\t\t\tboolean old";
  protected final String TEXT_754 = "_set_ = eVirtualIsSet(";
  protected final String TEXT_755 = ");";
  protected final String TEXT_756 = NL + "\t\t\tboolean old";
  protected final String TEXT_757 = "_set_ = (";
  protected final String TEXT_758 = " & ";
  protected final String TEXT_759 = "_ESETFLAG) != 0;";
  protected final String TEXT_760 = NL + "\t\t\t";
  protected final String TEXT_761 = " &= ~";
  protected final String TEXT_762 = "_ESETFLAG;";
  protected final String TEXT_763 = NL + "\t\t\tboolean old";
  protected final String TEXT_764 = "_set_ = ";
  protected final String TEXT_765 = "_set_;";
  protected final String TEXT_766 = NL + "\t\t\t";
  protected final String TEXT_767 = "_set_ = false;";
  protected final String TEXT_768 = NL + "\t\t\tif (isNotifying())" + NL + "\t\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_769 = ", null, null, old";
  protected final String TEXT_770 = "_set_);";
  protected final String TEXT_771 = NL + "    \t}";
  protected final String TEXT_772 = NL + "\t\t";
  protected final String TEXT_773 = " old";
  protected final String TEXT_774 = " = (";
  protected final String TEXT_775 = " & ";
  protected final String TEXT_776 = "_EFLAG) != 0;";
  protected final String TEXT_777 = NL + "\t\tObject old";
  protected final String TEXT_778 = " = eVirtualUnset(";
  protected final String TEXT_779 = ");";
  protected final String TEXT_780 = NL + "\t\t";
  protected final String TEXT_781 = " old";
  protected final String TEXT_782 = " = ";
  protected final String TEXT_783 = ";";
  protected final String TEXT_784 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_785 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_786 = NL + "\t\tboolean old";
  protected final String TEXT_787 = "_set_ = (";
  protected final String TEXT_788 = " & ";
  protected final String TEXT_789 = "_ESETFLAG) != 0;";
  protected final String TEXT_790 = NL + "\t\tboolean old";
  protected final String TEXT_791 = "_set_ = ";
  protected final String TEXT_792 = "_set_;";
  protected final String TEXT_793 = NL + "\t\t";
  protected final String TEXT_794 = " = null;";
  protected final String TEXT_795 = NL + "\t\t";
  protected final String TEXT_796 = " &= ~";
  protected final String TEXT_797 = "_ESETFLAG;";
  protected final String TEXT_798 = NL + "\t\t";
  protected final String TEXT_799 = "_set_ = false;";
  protected final String TEXT_800 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_801 = ", ";
  protected final String TEXT_802 = "isSetChange ? old";
  protected final String TEXT_803 = " : null";
  protected final String TEXT_804 = "old";
  protected final String TEXT_805 = ", null, ";
  protected final String TEXT_806 = "isSetChange";
  protected final String TEXT_807 = "old";
  protected final String TEXT_808 = "_set_";
  protected final String TEXT_809 = ");";
  protected final String TEXT_810 = NL + "\t\tif (";
  protected final String TEXT_811 = "_DEFAULT_) ";
  protected final String TEXT_812 = " |= ";
  protected final String TEXT_813 = "_EFLAG; else ";
  protected final String TEXT_814 = " &= ~";
  protected final String TEXT_815 = "_EFLAG;";
  protected final String TEXT_816 = NL + "\t\t";
  protected final String TEXT_817 = " = ";
  protected final String TEXT_818 = "_DEFAULT_;";
  protected final String TEXT_819 = NL + "\t\t";
  protected final String TEXT_820 = " &= ~";
  protected final String TEXT_821 = "_ESETFLAG;";
  protected final String TEXT_822 = NL + "\t\t";
  protected final String TEXT_823 = "_set_ = false;";
  protected final String TEXT_824 = NL + "\t\tif (isNotifying())" + NL + "\t\t\tnotify(ChangeKind.UNSET, ";
  protected final String TEXT_825 = ", ";
  protected final String TEXT_826 = "isSetChange ? old";
  protected final String TEXT_827 = " : ";
  protected final String TEXT_828 = "_DEFAULT_";
  protected final String TEXT_829 = "old";
  protected final String TEXT_830 = ", ";
  protected final String TEXT_831 = "_DEFAULT_, ";
  protected final String TEXT_832 = "isSetChange";
  protected final String TEXT_833 = "old";
  protected final String TEXT_834 = "_set_";
  protected final String TEXT_835 = ");";
  protected final String TEXT_836 = NL + "        unset(get";
  protected final String TEXT_837 = "(), getType(), ";
  protected final String TEXT_838 = ");";
  protected final String TEXT_839 = NL + "        unset";
  protected final String TEXT_840 = "(get";
  protected final String TEXT_841 = "());";
  protected final String TEXT_842 = NL + "\t\t// TODO: implement this method to unset the '";
  protected final String TEXT_843 = "' ";
  protected final String TEXT_844 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_845 = NL + "\t}" + NL;
  protected final String TEXT_846 = NL + "\t/**" + NL + "\t * Returns whether the value of the '{@link ";
  protected final String TEXT_847 = "#";
  protected final String TEXT_848 = " <em>";
  protected final String TEXT_849 = "</em>}' ";
  protected final String TEXT_850 = " is set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return whether the value of the '<em>";
  protected final String TEXT_851 = "</em>' ";
  protected final String TEXT_852 = " is set.";
  protected final String TEXT_853 = NL + "\t * @see #unset";
  protected final String TEXT_854 = "()";
  protected final String TEXT_855 = NL + "\t * @see #";
  protected final String TEXT_856 = "()";
  protected final String TEXT_857 = NL + "\t * @see #set";
  protected final String TEXT_858 = "(";
  protected final String TEXT_859 = ")";
  protected final String TEXT_860 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_861 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_862 = NL + "\tboolean isSet";
  protected final String TEXT_863 = "();" + NL;
  protected final String TEXT_864 = NL + "\tpublic boolean isSet";
  protected final String TEXT_865 = "()" + NL + "\t{";
  protected final String TEXT_866 = NL + "\t\treturn isSet(";
  protected final String TEXT_867 = ");";
  protected final String TEXT_868 = NL + "\t\t";
  protected final String TEXT_869 = " ";
  protected final String TEXT_870 = " = (";
  protected final String TEXT_871 = ")eVirtualGet(";
  protected final String TEXT_872 = ");";
  protected final String TEXT_873 = NL + "\t\treturn ";
  protected final String TEXT_874 = " != null && ((";
  protected final String TEXT_875 = ".Unsettable)";
  protected final String TEXT_876 = ").isSet();";
  protected final String TEXT_877 = NL + "\t\treturn eVirtualIsSet(";
  protected final String TEXT_878 = ");";
  protected final String TEXT_879 = NL + "\t\treturn (";
  protected final String TEXT_880 = " & ";
  protected final String TEXT_881 = "_ESETFLAG) != 0;";
  protected final String TEXT_882 = NL + "\t\treturn ";
  protected final String TEXT_883 = "_set_;";
  protected final String TEXT_884 = NL + "        return isSet(get";
  protected final String TEXT_885 = "(), getType(), ";
  protected final String TEXT_886 = ");";
  protected final String TEXT_887 = NL + "\t\treturn !((";
  protected final String TEXT_888 = ".Internal)get";
  protected final String TEXT_889 = "()).isEmpty(";
  protected final String TEXT_890 = ");";
  protected final String TEXT_891 = NL + "\t\t// TODO: implement this method to return whether the '";
  protected final String TEXT_892 = "' ";
  protected final String TEXT_893 = " is set" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_894 = NL + "\t}" + NL;
  protected final String TEXT_895 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_896 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_897 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_898 = NL + "\t * @model ";
  protected final String TEXT_899 = NL + "\t *        ";
  protected final String TEXT_900 = NL + "\t * @model";
  protected final String TEXT_901 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_902 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_903 = NL + "\t";
  protected final String TEXT_904 = " ";
  protected final String TEXT_905 = "(";
  protected final String TEXT_906 = ")";
  protected final String TEXT_907 = ";" + NL;
  protected final String TEXT_908 = NL + "\tpublic ";
  protected final String TEXT_909 = " ";
  protected final String TEXT_910 = "(";
  protected final String TEXT_911 = ")";
  protected final String TEXT_912 = NL + "\t{";
  protected final String TEXT_913 = NL + "\t\t";
  protected final String TEXT_914 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_915 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_916 = ".add" + NL + "\t\t\t\t\t(new ";
  protected final String TEXT_917 = NL + "\t\t\t\t\t\t(";
  protected final String TEXT_918 = ".ERROR," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_919 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_920 = ".";
  protected final String TEXT_921 = "," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_922 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
  protected final String TEXT_923 = "\", ";
  protected final String TEXT_924 = ".getObjectLabel(this, ";
  protected final String TEXT_925 = ") }),";
  protected final String TEXT_926 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
  protected final String TEXT_927 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_928 = NL + "\t}" + NL;
  protected final String TEXT_929 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eInverseAdd(";
  protected final String TEXT_930 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_931 = NL + "\t\t\tcase ";
  protected final String TEXT_932 = ":";
  protected final String TEXT_933 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_934 = ")((";
  protected final String TEXT_935 = ".InternalMapView)";
  protected final String TEXT_936 = "()).eMap()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_937 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_938 = ")";
  protected final String TEXT_939 = "()).basicAdd(otherEnd, changeContext);";
  protected final String TEXT_940 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\t\tchangeContext = eBasicRemoveFromContainer(changeContext);" + NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
  protected final String TEXT_941 = ", changeContext);";
  protected final String TEXT_942 = NL + "\t\t\t\t";
  protected final String TEXT_943 = " ";
  protected final String TEXT_944 = " = (";
  protected final String TEXT_945 = ")eVirtualGet(";
  protected final String TEXT_946 = ");";
  protected final String TEXT_947 = NL + "\t\t\t\tif (";
  protected final String TEXT_948 = " != null)";
  protected final String TEXT_949 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_950 = ")";
  protected final String TEXT_951 = ").inverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_952 = ", null, changeContext);";
  protected final String TEXT_953 = NL + "\t\t\t\t\tchangeContext = ((";
  protected final String TEXT_954 = ")";
  protected final String TEXT_955 = ").inverseRemove(this, ";
  protected final String TEXT_956 = ", ";
  protected final String TEXT_957 = ".class, changeContext);";
  protected final String TEXT_958 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_959 = "((";
  protected final String TEXT_960 = ")otherEnd, changeContext);";
  protected final String TEXT_961 = NL + "\t\t}";
  protected final String TEXT_962 = NL + "\t\treturn super.eInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_963 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_964 = NL + "\t}" + NL;
  protected final String TEXT_965 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext inverseRemove(";
  protected final String TEXT_966 = " otherEnd, int propertyIndex, ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_967 = NL + "\t\t\tcase ";
  protected final String TEXT_968 = ":";
  protected final String TEXT_969 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_970 = ")((";
  protected final String TEXT_971 = ".InternalMapView)";
  protected final String TEXT_972 = "()).eMap()).basicRemove(otherEnd, changeContext);";
  protected final String TEXT_973 = NL + "\t\t\t\treturn removeFrom";
  protected final String TEXT_974 = "(";
  protected final String TEXT_975 = "(), otherEnd, changeContext);";
  protected final String TEXT_976 = NL + "\t\t\t\treturn removeFromList(";
  protected final String TEXT_977 = "(), otherEnd, changeContext);";
  protected final String TEXT_978 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
  protected final String TEXT_979 = ", changeContext);";
  protected final String TEXT_980 = NL + "\t\t\t\treturn basicUnset";
  protected final String TEXT_981 = "(changeContext);";
  protected final String TEXT_982 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_983 = "(null, changeContext);";
  protected final String TEXT_984 = NL + "\t\t}";
  protected final String TEXT_985 = NL + "\t\treturn super.inverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_986 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, propertyIndex, changeContext);";
  protected final String TEXT_987 = NL + "\t}" + NL;
  protected final String TEXT_988 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ChangeContext eBasicRemoveFromContainerFeature(ChangeContext changeContext)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID)" + NL + "\t\t{";
  protected final String TEXT_989 = NL + "\t\t\tcase ";
  protected final String TEXT_990 = ":" + NL + "\t\t\t\treturn eInternalContainer().inverseRemove(this, ";
  protected final String TEXT_991 = ", ";
  protected final String TEXT_992 = ".class, changeContext);";
  protected final String TEXT_993 = NL + "\t\t}";
  protected final String TEXT_994 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(changeContext);";
  protected final String TEXT_995 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(changeContext);";
  protected final String TEXT_996 = NL + "\t}" + NL;
  protected final String TEXT_997 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object get(int propertyIndex, boolean resolve)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_998 = NL + "\t\t\tcase ";
  protected final String TEXT_999 = ":";
  protected final String TEXT_1000 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1001 = "() ? Boolean.TRUE : Boolean.FALSE;";
  protected final String TEXT_1002 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_1003 = "(";
  protected final String TEXT_1004 = "());";
  protected final String TEXT_1005 = NL + "\t\t\t\tif (resolve) return ";
  protected final String TEXT_1006 = "();" + NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1007 = "();";
  protected final String TEXT_1008 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1009 = ".InternalMapView)";
  protected final String TEXT_1010 = "()).eMap();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1011 = "();";
  protected final String TEXT_1012 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1013 = "();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1014 = "().map();";
  protected final String TEXT_1015 = NL + "\t\t\t\t// XXX query introduce coreType as an argument? -- semantic = if true -- coreType - return the core EMF object if value is a non-EMF wrapper/view" + NL + "\t\t\t\t//if (coreType) " + NL + "\t\t\t\treturn ";
  protected final String TEXT_1016 = "();";
  protected final String TEXT_1017 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1018 = "();" + NL + "\t\t\t\treturn ((";
  protected final String TEXT_1019 = ".Internal)";
  protected final String TEXT_1020 = "()).getWrapper();";
  protected final String TEXT_1021 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1022 = "();";
  protected final String TEXT_1023 = NL + "\t\t}";
  protected final String TEXT_1024 = NL + "\t\treturn super.get(propertyIndex, resolve);";
  protected final String TEXT_1025 = NL + "\t\treturn eDynamicGet(propertyIndex, resolve, coreType);";
  protected final String TEXT_1026 = NL + "\t}" + NL;
  protected final String TEXT_1027 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void set(int propertyIndex, Object newValue)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1028 = NL + "\t\t\tcase ";
  protected final String TEXT_1029 = ":";
  protected final String TEXT_1030 = NL + "      \tset";
  protected final String TEXT_1031 = "(";
  protected final String TEXT_1032 = "(), newValue);";
  protected final String TEXT_1033 = NL + "\t\t\t\t((";
  protected final String TEXT_1034 = ".Internal)";
  protected final String TEXT_1035 = "()).set(newValue);";
  protected final String TEXT_1036 = NL + "\t\t\t\t((";
  protected final String TEXT_1037 = ".Setting)((";
  protected final String TEXT_1038 = ".InternalMapView)";
  protected final String TEXT_1039 = "()).eMap()).set(newValue);";
  protected final String TEXT_1040 = NL + "\t\t\t\t((";
  protected final String TEXT_1041 = ".Setting)";
  protected final String TEXT_1042 = "()).set(newValue);";
  protected final String TEXT_1043 = NL + "\t\t\t\t";
  protected final String TEXT_1044 = "().clear();" + NL + "\t\t\t\t";
  protected final String TEXT_1045 = "().addAll((";
  protected final String TEXT_1046 = ")newValue);";
  protected final String TEXT_1047 = NL + "\t\t\t\tset";
  protected final String TEXT_1048 = "(((";
  protected final String TEXT_1049 = ")newValue).";
  protected final String TEXT_1050 = "());";
  protected final String TEXT_1051 = NL + "\t\t\t\tset";
  protected final String TEXT_1052 = "((";
  protected final String TEXT_1053 = ")newValue);";
  protected final String TEXT_1054 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1055 = NL + "\t\t}";
  protected final String TEXT_1056 = NL + "\t\tsuper.set(propertyIndex, newValue);";
  protected final String TEXT_1057 = NL + "\t\teDynamicSet(propertyIndex, newValue);";
  protected final String TEXT_1058 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void unset(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1059 = NL + "\t\t\tcase ";
  protected final String TEXT_1060 = ":";
  protected final String TEXT_1061 = NL + "\t\t\t\tunset";
  protected final String TEXT_1062 = "(";
  protected final String TEXT_1063 = "());";
  protected final String TEXT_1064 = NL + "\t\t\t\t";
  protected final String TEXT_1065 = "().clear();";
  protected final String TEXT_1066 = NL + "\t\t\t\tunset";
  protected final String TEXT_1067 = "();";
  protected final String TEXT_1068 = NL + "\t\t\t\tset";
  protected final String TEXT_1069 = "((";
  protected final String TEXT_1070 = ")null);";
  protected final String TEXT_1071 = NL + "\t\t\t\tset";
  protected final String TEXT_1072 = "(";
  protected final String TEXT_1073 = "_DEFAULT_);";
  protected final String TEXT_1074 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1075 = NL + "\t\t}";
  protected final String TEXT_1076 = NL + "\t\tsuper.unset(propertyIndex);";
  protected final String TEXT_1077 = NL + "\t\teDynamicUnset(propertyIndex);";
  protected final String TEXT_1078 = NL + "\t}" + NL;
  protected final String TEXT_1079 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isSet(int propertyIndex)" + NL + "\t{" + NL + "\t\tswitch (propertyIndex)" + NL + "\t\t{";
  protected final String TEXT_1080 = NL + "\t\t\tcase ";
  protected final String TEXT_1081 = ":";
  protected final String TEXT_1082 = NL + "\t\t\t\treturn !is";
  protected final String TEXT_1083 = "Empty(";
  protected final String TEXT_1084 = "());";
  protected final String TEXT_1085 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1086 = " != null && !is";
  protected final String TEXT_1087 = "Empty(";
  protected final String TEXT_1088 = "());";
  protected final String TEXT_1089 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1090 = " != null && !";
  protected final String TEXT_1091 = ".isEmpty();";
  protected final String TEXT_1092 = NL + "\t\t\t\t";
  protected final String TEXT_1093 = " ";
  protected final String TEXT_1094 = " = (";
  protected final String TEXT_1095 = ")eVirtualGet(";
  protected final String TEXT_1096 = ");" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1097 = " != null && !";
  protected final String TEXT_1098 = ".isEmpty();";
  protected final String TEXT_1099 = NL + "\t\t\t\treturn !";
  protected final String TEXT_1100 = "().isEmpty();";
  protected final String TEXT_1101 = NL + "\t\t\t\treturn isSet";
  protected final String TEXT_1102 = "();";
  protected final String TEXT_1103 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1104 = " != null;";
  protected final String TEXT_1105 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1106 = ") != null;";
  protected final String TEXT_1107 = NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1108 = "() != null;";
  protected final String TEXT_1109 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1110 = " != null;";
  protected final String TEXT_1111 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1112 = ") != null;";
  protected final String TEXT_1113 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1114 = "() != null;";
  protected final String TEXT_1115 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1116 = " & ";
  protected final String TEXT_1117 = "_EFLAG) != 0) != ";
  protected final String TEXT_1118 = "_DEFAULT_;";
  protected final String TEXT_1119 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1120 = " != ";
  protected final String TEXT_1121 = "_DEFAULT_;";
  protected final String TEXT_1122 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1123 = ", ";
  protected final String TEXT_1124 = "_DEFAULT_) != ";
  protected final String TEXT_1125 = "_DEFAULT_;";
  protected final String TEXT_1126 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1127 = "() != ";
  protected final String TEXT_1128 = "_DEFAULT_;";
  protected final String TEXT_1129 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1130 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1131 = " != null : !";
  protected final String TEXT_1132 = "_DEFAULT_.equals(";
  protected final String TEXT_1133 = ");";
  protected final String TEXT_1134 = NL + "\t\t\t\t";
  protected final String TEXT_1135 = " ";
  protected final String TEXT_1136 = " = (";
  protected final String TEXT_1137 = ")eVirtualGet(";
  protected final String TEXT_1138 = ", ";
  protected final String TEXT_1139 = "_DEFAULT_);" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1140 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1141 = " != null : !";
  protected final String TEXT_1142 = "_DEFAULT_.equals(";
  protected final String TEXT_1143 = ");";
  protected final String TEXT_1144 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1145 = "_DEFAULT_ == null ? ";
  protected final String TEXT_1146 = "() != null : !";
  protected final String TEXT_1147 = "_DEFAULT_.equals(";
  protected final String TEXT_1148 = "());";
  protected final String TEXT_1149 = NL + "\t\t}";
  protected final String TEXT_1150 = NL + "\t\treturn super.isSet(propertyIndex);";
  protected final String TEXT_1151 = NL + "\t\treturn eDynamicIsSet(propertyIndex);";
  protected final String TEXT_1152 = NL + "\t}" + NL;
  protected final String TEXT_1153 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1154 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1155 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1156 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1157 = ": return ";
  protected final String TEXT_1158 = ";";
  protected final String TEXT_1159 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1160 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1161 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1162 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1163 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1164 = ": return ";
  protected final String TEXT_1165 = ";";
  protected final String TEXT_1166 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1167 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);" + NL + "\t}" + NL;
  protected final String TEXT_1168 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_1169 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualValues(Object[] newValues)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1170 = " = newValues;" + NL + "\t}" + NL;
  protected final String TEXT_1171 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1172 = NL + "\t\t\tcase ";
  protected final String TEXT_1173 = " :" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1174 = ";";
  protected final String TEXT_1175 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setVirtualIndexBits(int offset, int newIndexBits)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1176 = NL + "\t\t\tcase ";
  protected final String TEXT_1177 = " :" + NL + "\t\t\t\t";
  protected final String TEXT_1178 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_1179 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_1180 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String toString()" + NL + "\t{" + NL + "\t\tif (isProxy()) return super.toString();" + NL + "" + NL + "\t\tStringBuffer result = new StringBuffer(super.toString());";
  protected final String TEXT_1181 = NL + "\t\tresult.append(\" (";
  protected final String TEXT_1182 = ": \");";
  protected final String TEXT_1183 = NL + "\t\tresult.append(\", ";
  protected final String TEXT_1184 = ": \");";
  protected final String TEXT_1185 = NL + "\t\tif (eVirtualIsSet(";
  protected final String TEXT_1186 = ")) result.append(eVirtualGet(";
  protected final String TEXT_1187 = ")); else result.append(\"<unset>\");";
  protected final String TEXT_1188 = NL + "\t\tif (";
  protected final String TEXT_1189 = "(";
  protected final String TEXT_1190 = " & ";
  protected final String TEXT_1191 = "_ESETFLAG) != 0";
  protected final String TEXT_1192 = "_set_";
  protected final String TEXT_1193 = ") result.append((";
  protected final String TEXT_1194 = " & ";
  protected final String TEXT_1195 = "_EFLAG) != 0); else result.append(\"<unset>\");";
  protected final String TEXT_1196 = NL + "\t\tif (";
  protected final String TEXT_1197 = "(";
  protected final String TEXT_1198 = " & ";
  protected final String TEXT_1199 = "_ESETFLAG) != 0";
  protected final String TEXT_1200 = "_set_";
  protected final String TEXT_1201 = ") result.append(";
  protected final String TEXT_1202 = "); else result.append(\"<unset>\");";
  protected final String TEXT_1203 = NL + "\t\tresult.append(eVirtualGet(";
  protected final String TEXT_1204 = ", ";
  protected final String TEXT_1205 = "_DEFAULT_";
  protected final String TEXT_1206 = "));";
  protected final String TEXT_1207 = NL + "\t\tresult.append((";
  protected final String TEXT_1208 = " & ";
  protected final String TEXT_1209 = "_EFLAG) != 0);";
  protected final String TEXT_1210 = NL + "\t\tresult.append(";
  protected final String TEXT_1211 = ");";
  protected final String TEXT_1212 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}" + NL;
  protected final String TEXT_1213 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)" + NL + "\t\t{" + NL + "\t\t\tObject theKey = getKey();" + NL + "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL + "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + " \t * <!-- begin-user-doc -->" + NL + " \t * <!-- end-user-doc -->" + NL + " \t * @generated" + NL + " \t */" + NL + "\tpublic Object getKey()" + NL + "\t{" + NL + "  \t";
  protected final String TEXT_1214 = NL + "\t\treturn new ";
  protected final String TEXT_1215 = "(getTypedKey());" + NL + " \t";
  protected final String TEXT_1216 = NL + "\t\treturn getTypedKey();" + NL + "  \t";
  protected final String TEXT_1217 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(Object key)" + NL + "\t{";
  protected final String TEXT_1218 = NL + "\t\tgetTypedKey().addAll((";
  protected final String TEXT_1219 = ")key);";
  protected final String TEXT_1220 = NL + "\t\tsetTypedKey(((";
  protected final String TEXT_1221 = ")key).";
  protected final String TEXT_1222 = "());";
  protected final String TEXT_1223 = NL + "\t\tsetTypedKey((";
  protected final String TEXT_1224 = ")key);";
  protected final String TEXT_1225 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getValue()" + NL + "\t{" + NL + " \t";
  protected final String TEXT_1226 = NL + "\t\treturn new ";
  protected final String TEXT_1227 = "(getTypedValue());" + NL + " \t";
  protected final String TEXT_1228 = NL + "\t\treturn getTypedValue();" + NL + " \t";
  protected final String TEXT_1229 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object setValue(Object value)" + NL + "\t{" + NL + "\t\tObject oldValue = getValue();" + NL + "  \t";
  protected final String TEXT_1230 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll((";
  protected final String TEXT_1231 = ")value);" + NL + "  \t";
  protected final String TEXT_1232 = NL + "\t\tsetTypedValue(((";
  protected final String TEXT_1233 = ")value).";
  protected final String TEXT_1234 = "());" + NL + "  \t";
  protected final String TEXT_1235 = NL + "\t\tsetTypedValue((";
  protected final String TEXT_1236 = ")value);" + NL + "  \t";
  protected final String TEXT_1237 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1238 = " getEMap()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1239 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
  protected final String TEXT_1240 = ")container.get(eContainmentFeature());" + NL + "\t}";
  protected final String TEXT_1241 = NL + "} //";
  protected final String TEXT_1242 = NL;

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
    String publicStaticFinalFlag = isImplementation ? "public static final " : "";
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
    if (isInterface) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_12);
    if (genClass.hasDocumentation()) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genClass.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    if (!genClass.getGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_16);
    for (Iterator i=genClass.getGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_20);
    }
    }
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_25);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_26);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_28);
    }}
    if (genClass.needsRootExtendsInterfaceExtendsTag()) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
    }
    stringBuffer.append(TEXT_30);
    } else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_32);
    if (!genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_33);
    for (Iterator i=genClass.getImplementedGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genClass.getQualifiedClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_40);
    if (genClass.isAbstract()) {
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(genClass.getClassExtends());
    stringBuffer.append(genClass.getClassImplements());
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genClass.getInterfaceName());
    stringBuffer.append(genClass.getInterfaceExtends());
    }
    stringBuffer.append(TEXT_44);
    if (genModel.getCopyrightText() != null) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genModel.getCopyrightText());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_48);
    }
    if (isImplementation && genModel.getDriverNumber() != null) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genModel.getDriverNumber());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_52);
    }
    if (isImplementation && genClass.isJavaIOSerializable()) {
    stringBuffer.append(TEXT_53);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_55);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) {
    for (Iterator i = eVirtualIndexBitFields.iterator(); i.hasNext();) { String eVirtualIndexBitField = (String)i.next();
    stringBuffer.append(TEXT_56);
    stringBuffer.append(eVirtualIndexBitField);
    stringBuffer.append(TEXT_57);
    }
    }
    }
    }
    if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled() && genModel.getBooleanFlagsReservedBits() == -1) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genModel.getBooleanFlagsField());
    stringBuffer.append(TEXT_59);
    }
    if (isImplementation && !genModel.isReflectiveDelegation()) {
    for (Iterator f=genClass.getAllGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next();
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_62);
    String featureValue = "";
    List allFeatures = genClass.getAllGenFeatures();
    int g = allFeatures.indexOf(genFeature);
    GenClass base = genClass.getBaseGenClass();
    if (base == null)
    {
      featureValue = Integer.toString(g);
    } else {
      int baseCount = base.getFeatureCount();    
      if (g < baseCount)
      {
        featureValue = base.getClassName() + "." + genFeature.getUpperName();
      } else {
        String baseCountID = base.getClassName() + "." + "SDO_PROPERTY_COUNT";
        featureValue =  baseCountID + " + " + Integer.toString(g - baseCount);
       }
     }
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(featureValue);
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    String featureCount = "";
	GenClass base = genClass.getBaseGenClass();
    if (base == null)
    {
      featureCount = Integer.toString(genClass.getFeatureCount());
    } 
    else {
      String baseCountID = base.getClassName() + "." + "SDO_PROPERTY_COUNT";
      featureCount = baseCountID + " + " + Integer.toString(genClass.getFeatureCount() - base.getFeatureCount());
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(featureCount);
    stringBuffer.append(TEXT_68);
    for (Iterator i=genClass.getDeclaredFieldGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genFeature.isListType() || genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genModel.getImportedName(genFeature.getType()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_75);
    }
    if (genModel.isArrayAccessors() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_82);
    }
    } else {
    if (!genFeature.isVolatile() || !genModel.isReflectiveDelegation() && (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable())) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genFeature.getStaticDefaultValue());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genModel.getNonNLS(genFeature.getStaticDefaultValue()));
    stringBuffer.append(TEXT_91);
    }
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    if (genClass.getFlagIndex(genFeature) > 31 && genClass.getFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append("<< " + genClass.getFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_100);
    } else {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_108);
    }
    }
    }
    if (genClass.isESetField(genFeature)) {
    if (genClass.isESetFlag(genFeature)) {
    if (genClass.getESetFlagIndex(genFeature) > 31 && genClass.getESetFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append("<< " + genClass.getESetFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_115);
    } else {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_119);
    }
    }
    }
    //Class/declaredFieldGenFeature.override.javajetinc
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_121);
    for (Iterator i=genClass.getFlagGenFeatures("true").iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genPackage.getImportedFactoryClassName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(genPackage.getImportedFactoryInterfaceName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_129);
    }
    for (Iterator i=(isImplementation ? genClass.getImplementedGenFeatures() : genClass.getDeclaredGenFeatures()).iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_130);
    if (!isImplementation) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_133);
    } else {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_136);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_141);
    } else {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    if (!isImplementation) {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_154);
    } else {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    if (!isImplementation) {
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_162);
    } else {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_164);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_166);
    } else {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    if (!isImplementation) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_175);
    } else {
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    if (!isImplementation) {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_187);
    } else {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_191);
    }
    }
    if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_194);
    if (genFeature.isListType()) {
    if (genFeature.isMapType()) { GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature(); GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature(); 
    stringBuffer.append(TEXT_195);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_196);
    stringBuffer.append(keyFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_197);
    } else {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(keyFeature.getType());
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_201);
    stringBuffer.append(valueFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_202);
    } else {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(valueFeature.getType());
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    } else if (!genFeature.isWrappedFeatureMapType() && !(genModel.isSuppressEMFMetaData() && "org.eclipse.emf.ecore.EObject".equals(genFeature.getQualifiedListItemType()))) {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(genFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_207);
    }
    } else if (genFeature.isSetDefaultValue()) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_209);
    }
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    stringBuffer.append(TEXT_211);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(reverseGenFeature.getFormattedName());
    stringBuffer.append(TEXT_215);
    }
    }
    stringBuffer.append(TEXT_216);
    if (!genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_217);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    if (genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(genFeature.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_222);
    }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_225);
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_227);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_228);
    }
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_229);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_230);
    }
    }
    if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_233);
    }
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_234);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_236);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_237);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    }
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_239);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_240);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_241);
    }}
    stringBuffer.append(TEXT_242);
    } else {
    stringBuffer.append(TEXT_243);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_244);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_246);
    } else {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_249);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_250);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_251);
    }
    stringBuffer.append(TEXT_252);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_254);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_255);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_256);
    }
    stringBuffer.append(TEXT_257);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_258);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_259);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_260);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_261);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_262);
    }
    stringBuffer.append(TEXT_263);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_264);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_265);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_268);
    } else {
				if (genFeature.getType().equals("commonj.sdo.Sequence")){
    stringBuffer.append(TEXT_269);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_271);
    } else {
    stringBuffer.append(TEXT_272);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_274);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_275);
    }}
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
    stringBuffer.append(TEXT_277);
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_278);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_280);
    } else {
    if (genFeature.isResolveProxies()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_281);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_282);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_285);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_286);
    }
    stringBuffer.append(TEXT_287);
    }
    stringBuffer.append(TEXT_288);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(genFeature.getSafeNameAsEObject());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_291);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_294);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_295);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_297);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_298);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_299);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_300);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_301);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_302);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_303);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_304);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_305);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_306);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_307);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_308);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.ChangeContext"));
    stringBuffer.append(TEXT_309);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_312);
    }
    stringBuffer.append(TEXT_313);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_314);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_315);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_316);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_317);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_318);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_319);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_320);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    } else if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_323);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_324);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_325);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_326);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_329);
    }
    stringBuffer.append(TEXT_330);
    }
    if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_331);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_333);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_334);
    }
    stringBuffer.append(TEXT_335);
    } else if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_336);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_337);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_338);
    } else {
    stringBuffer.append(TEXT_339);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_340);
    }
    }
    } else {//volatile
    if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_341);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_342);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_344);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_347);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_349);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_350);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (genFeature.isFeatureMapType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_351);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_352);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_353);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_354);
    } else {
    stringBuffer.append(TEXT_355);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_356);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_357);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_358);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_359);
    }
    } else if (genFeature.isListType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_360);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_361);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_362);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_363);
    } else {
    stringBuffer.append(TEXT_364);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_365);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_366);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_367);
    }
    } else {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_368);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_369);
    }
    stringBuffer.append(TEXT_370);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_371);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_372);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_373);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_374);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_375);
    }
    stringBuffer.append(TEXT_376);
    } else {
    stringBuffer.append(TEXT_377);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_378);
    }
    stringBuffer.append(TEXT_379);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_380);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_381);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_382);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    }
    }
    } else {
    stringBuffer.append(TEXT_386);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_387);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_388);
    //Class/getGenFeature.todo.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_389);
    }
    //Class/getGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
    stringBuffer.append(TEXT_390);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_391);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_392);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_393);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_394);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_395);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_396);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_397);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_398);
    } else {
    stringBuffer.append(TEXT_399);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_400);
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_401);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_402);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_403);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_404);
    } else {
    stringBuffer.append(TEXT_405);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_406);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_407);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_408);
    }
    } else {
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_410);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_411);
    //Class/basicGetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_412);
    //Class/basicGetGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_413);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_414);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_415);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_416);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_417);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_418);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_420);
    } else {
    stringBuffer.append(TEXT_421);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_422);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_423);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_424);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_426);
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_427);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_428);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_429);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_430);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_431);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_432);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_434);
    } else {
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_437);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_438);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_439);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_441);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_442);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_443);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_444);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_445);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_446);
    } else {
    stringBuffer.append(TEXT_447);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_448);
    }
    stringBuffer.append(TEXT_449);
    } else {
    stringBuffer.append(TEXT_450);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_451);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_452);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_454);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_455);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_456);
    }
    stringBuffer.append(TEXT_457);
    }
    stringBuffer.append(TEXT_458);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_459);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_460);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_461);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_462);
    } else {
    stringBuffer.append(TEXT_463);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_464);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_465);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_466);
    }
    } else {
    stringBuffer.append(TEXT_467);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_468);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_469);
    //Class/basicSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_470);
    //Class/basicSetGenFeature.override.javajetinc
    }
    if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
    if (isInterface) { 
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_472);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_473);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_474);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_475);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_476);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_477);
    if (genFeature.isEnumType()) {
    stringBuffer.append(TEXT_478);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_479);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_480);
    }
    if (!genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_481);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_482);
    }
    }
    stringBuffer.append(TEXT_483);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_484);
    } else {
    stringBuffer.append(TEXT_485);
    }
    if (!isImplementation) { 
    stringBuffer.append(TEXT_486);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_487);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_488);
    } else {
    stringBuffer.append(TEXT_489);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_491);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_492);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_493);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_494);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_495);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_496);
    }
    stringBuffer.append(TEXT_497);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_498);
    }
    stringBuffer.append(TEXT_499);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_500);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_501);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_502);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_503);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_504);
    stringBuffer.append(genFeature.getEObjectCast());
    stringBuffer.append(TEXT_505);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_506);
    stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
    stringBuffer.append(TEXT_507);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_508);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_509);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_510);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_512);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_513);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_515);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_516);
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_517);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_519);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_520);
    }
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_521);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_523);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_524);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_525);
    }
    stringBuffer.append(TEXT_526);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_527);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_528);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_529);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_530);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_531);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_532);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_533);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_534);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_535);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_536);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_537);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_538);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_539);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_541);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_542);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_543);
    }
    stringBuffer.append(TEXT_544);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_545);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_546);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_547);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_548);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_549);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_551);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_552);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_553);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_554);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_555);
    }
    stringBuffer.append(TEXT_556);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_558);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_559);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_560);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_561);
    }
    stringBuffer.append(TEXT_562);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_563);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_564);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_565);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_566);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_567);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_568);
    }
    stringBuffer.append(TEXT_569);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_570);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_571);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_572);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_573);
    }
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_574);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_575);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_576);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_578);
    }
    stringBuffer.append(TEXT_579);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_580);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_581);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_582);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_583);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_584);
    } else {
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_585);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_586);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_587);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_588);
    }
    }
    if (genFeature.isEnumType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_589);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_590);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_591);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_592);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_593);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_594);
    } else {
    stringBuffer.append(TEXT_595);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_596);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_597);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_598);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_599);
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_600);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_601);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_602);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_603);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_604);
    } else {
    stringBuffer.append(TEXT_605);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_606);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_607);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_608);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_609);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_610);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_611);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_612);
    }
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_613);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_614);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_615);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_616);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_617);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_618);
    }
    stringBuffer.append(TEXT_619);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_620);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_621);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_622);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_623);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_624);
    }
    stringBuffer.append(TEXT_625);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_626);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_627);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_628);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_629);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_630);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_631);
    }
    stringBuffer.append(TEXT_632);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_633);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_634);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_635);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_636);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_637);
    } else {
    stringBuffer.append(TEXT_638);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_639);
    }
    stringBuffer.append(TEXT_640);
    }
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_641);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_642);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_643);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_644);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_645);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_646);
    }
    stringBuffer.append(TEXT_647);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_648);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_649);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_650);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_651);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_652);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_653);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_654);
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_655);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_656);
    }
    stringBuffer.append(TEXT_657);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_658);
    }
    stringBuffer.append(TEXT_659);
    } else {
    stringBuffer.append(TEXT_660);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_661);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_662);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_663);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_664);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_665);
    }
    stringBuffer.append(TEXT_666);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()){
    stringBuffer.append(TEXT_667);
    }
    stringBuffer.append(TEXT_668);
    }
    } else {
    stringBuffer.append(TEXT_669);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_670);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_671);
    //Class/setGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_672);
    }
    //Class/setGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
    stringBuffer.append(TEXT_673);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_674);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_675);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_676);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_677);
    } else {
    stringBuffer.append(TEXT_678);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_679);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_680);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_681);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_682);
    }
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_683);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_684);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_685);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_686);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_687);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_688);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_689);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_690);
    } else {
    stringBuffer.append(TEXT_691);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_692);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_693);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_694);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_695);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_696);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_697);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_698);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_699);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_700);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_701);
    } else {
    stringBuffer.append(TEXT_702);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_703);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_704);
    } else {
    stringBuffer.append(TEXT_705);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_706);
    }
    stringBuffer.append(TEXT_707);
    }
    } else {
    stringBuffer.append(TEXT_708);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_709);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_710);
    //Class/basicUnsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_711);
    //Class.basicUnsetGenFeature.override.javajetinc
    }
    if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_712);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_713);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_714);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_715);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_716);
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_717);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_718);
    }
    stringBuffer.append(TEXT_719);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_720);
    if (!genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_721);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_722);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_723);
    }
    stringBuffer.append(TEXT_724);
    } else {
    stringBuffer.append(TEXT_725);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_726);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_727);
    } else {
    stringBuffer.append(TEXT_728);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_729);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_730);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_731);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    stringBuffer.append(TEXT_732);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_733);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_734);
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_735);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_736);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_737);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_738);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_739);
    }
    stringBuffer.append(TEXT_740);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_741);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_742);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_743);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_744);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_745);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_746);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_747);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_748);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_749);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_750);
    }
    stringBuffer.append(TEXT_751);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_752);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_753);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_754);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_755);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_756);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_757);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_758);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_759);
    }
    stringBuffer.append(TEXT_760);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_761);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_762);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_763);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_764);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_765);
    }
    stringBuffer.append(TEXT_766);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_767);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_768);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_769);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_770);
    }
    stringBuffer.append(TEXT_771);
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_772);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_773);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_774);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_775);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_776);
    }
    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_777);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_778);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_779);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_780);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_781);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_782);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_783);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_784);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_785);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_786);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_787);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_789);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_790);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_791);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_792);
    }
    }
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_793);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_794);
    if (!genModel.isVirtualDelegation()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_795);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_796);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_797);
    } else {
    stringBuffer.append(TEXT_798);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_799);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_800);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_801);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_802);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_803);
    } else {
    stringBuffer.append(TEXT_804);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_805);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_806);
    } else {
    stringBuffer.append(TEXT_807);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_808);
    }
    stringBuffer.append(TEXT_809);
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_810);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_811);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_812);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_813);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_814);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_815);
    } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_816);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_817);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_818);
    }
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_819);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_820);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_821);
    } else {
    stringBuffer.append(TEXT_822);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_823);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_824);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_825);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_826);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_827);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_828);
    } else {
    stringBuffer.append(TEXT_829);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_830);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_831);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_832);
    } else {
    stringBuffer.append(TEXT_833);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_834);
    }
    stringBuffer.append(TEXT_835);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_836);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_837);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_838);
    } else {
    stringBuffer.append(TEXT_839);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_840);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_841);
    }
    } else {
    stringBuffer.append(TEXT_842);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_843);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_844);
    //Class/unsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_845);
    }
    //Class/unsetGenFeature.override.javajetinc
    }
    if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_846);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_847);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_848);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_849);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_850);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_851);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_852);
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_853);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_854);
    }
    stringBuffer.append(TEXT_855);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_856);
    if (!genFeature.isListType() && genFeature.isChangeable() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_857);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_858);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_859);
    }
    stringBuffer.append(TEXT_860);
    } else {
    stringBuffer.append(TEXT_861);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_862);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_863);
    } else {
    stringBuffer.append(TEXT_864);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_865);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_866);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_867);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_868);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_869);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_870);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_871);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_872);
    }
    stringBuffer.append(TEXT_873);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_874);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_875);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_876);
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_877);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_878);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_879);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_880);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_881);
    } else {
    stringBuffer.append(TEXT_882);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_883);
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_884);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_885);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_886);
    } else {
    stringBuffer.append(TEXT_887);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_888);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_889);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_890);
    }
    } else {
    stringBuffer.append(TEXT_891);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_892);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_893);
    //Class/isSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_894);
    }
    //Class/isSetGenFeature.override.javajetinc
    }
    //Class/genFeature.override.javajetinc
    }//for
    for (Iterator i= (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations()).iterator(); i.hasNext();) { GenOperation genOperation = (GenOperation)i.next();
    if (isInterface) {
    stringBuffer.append(TEXT_895);
    if (genOperation.hasDocumentation()) {
    stringBuffer.append(TEXT_896);
    stringBuffer.append(genOperation.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_897);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genOperation.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_898);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_899);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_900);
    }}
    stringBuffer.append(TEXT_901);
    } else {
    stringBuffer.append(TEXT_902);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_903);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_904);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_905);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_906);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_907);
    } else {
    stringBuffer.append(TEXT_908);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_909);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_910);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_911);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_912);
    if (genOperation.hasBody()) {
    stringBuffer.append(TEXT_913);
    stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
    } else if (genOperation.isInvariant()) {GenClass opClass = genOperation.getGenClass(); String diagnostics = ((GenParameter)genOperation.getGenParameters().get(0)).getName(); String context = ((GenParameter)genOperation.getGenParameters().get(1)).getName();
    stringBuffer.append(TEXT_914);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
    stringBuffer.append(TEXT_917);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
    stringBuffer.append(TEXT_918);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_919);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_920);
    stringBuffer.append(opClass.getOperationID(genOperation));
    stringBuffer.append(TEXT_921);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
    stringBuffer.append(TEXT_922);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_923);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
    stringBuffer.append(TEXT_924);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_926);
    } else {
    stringBuffer.append(TEXT_927);
    //Class/implementedGenOperation.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_928);
    }
    //Class/implementedGenOperation.override.javajetinc
    }//for
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
    stringBuffer.append(TEXT_929);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_930);
    for (Iterator i=genClass.getEInverseAddGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_931);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_932);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_933);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_935);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_936);
    } else {
    stringBuffer.append(TEXT_937);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_939);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_940);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_941);
    } else {
    if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_942);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_943);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_944);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_945);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_946);
    }
    stringBuffer.append(TEXT_947);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_948);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_949);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_950);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_951);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_952);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_953);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_954);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_955);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_956);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_957);
    }
    stringBuffer.append(TEXT_958);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_959);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_960);
    }
    }
    }
    stringBuffer.append(TEXT_961);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_962);
    } else {
    stringBuffer.append(TEXT_963);
    }
    stringBuffer.append(TEXT_964);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
    stringBuffer.append(TEXT_965);
    stringBuffer.append(genModel.getImportedName("java.lang.Object"));
    stringBuffer.append(TEXT_966);
    for (Iterator i=genClass.getEInverseRemoveGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_967);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_968);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_969);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_970);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_972);
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_973);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_974);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_975);
    } else {
    stringBuffer.append(TEXT_976);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_977);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_978);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_979);
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_980);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_981);
    } else {
    stringBuffer.append(TEXT_982);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_983);
    }
    }
    }
    stringBuffer.append(TEXT_984);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_985);
    } else {
    stringBuffer.append(TEXT_986);
    }
    stringBuffer.append(TEXT_987);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
    stringBuffer.append(TEXT_988);
    for (Iterator i=genClass.getEBasicRemoveFromContainerGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_989);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_990);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_991);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_992);
    }
    }
    stringBuffer.append(TEXT_993);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_994);
    } else {
    stringBuffer.append(TEXT_995);
    }
    stringBuffer.append(TEXT_996);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_997);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_998);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_999);
    if (genFeature.isPrimitiveType()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1001);
    } else {
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1004);
    }
    } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1007);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1011);
    } else {
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1014);
    }
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1016);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1020);
    } else {
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1022);
    }
    }
    }
    stringBuffer.append(TEXT_1023);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1024);
    } else {
    stringBuffer.append(TEXT_1025);
    }
    stringBuffer.append(TEXT_1026);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
    stringBuffer.append(TEXT_1027);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1029);
    if (genFeature.isListType()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1032);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1035);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1039);
    } else {
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1042);
    }
    } else {
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1046);
    }
    } else if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1050);
    } else {
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1053);
    }
    stringBuffer.append(TEXT_1054);
    }
    }
    stringBuffer.append(TEXT_1055);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1056);
    } else {
    stringBuffer.append(TEXT_1057);
    }
    stringBuffer.append(TEXT_1058);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1060);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1063);
    } else {
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1065);
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1067);
    } else if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1070);
    } else {
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1073);
    }
    stringBuffer.append(TEXT_1074);
    }
    }
    stringBuffer.append(TEXT_1075);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1076);
    } else {
    stringBuffer.append(TEXT_1077);
    }
    stringBuffer.append(TEXT_1078);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1079);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1081);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1084);
    } else {
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1088);
    }
    } else {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1091);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1098);
    } else {
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1100);
    }
    }
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1102);
    } else if (genFeature.isResolveProxies()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1104);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1106);
    } else {
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1108);
    }
    }
    } else if (genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1110);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1112);
    } else {
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1114);
    }
    }
    } else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1118);
    } else {
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1121);
    }
    } else {
    if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1125);
    } else {
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1128);
    }
    }
    } else {//datatype
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1133);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1143);
    } else {
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1148);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1149);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1150);
    } else {
    stringBuffer.append(TEXT_1151);
    }
    stringBuffer.append(TEXT_1152);
    //Class/eIsSet.override.javajetinc
    }
    if (isImplementation && !genClass.getMixinGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1153);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1155);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1158);
    }
    stringBuffer.append(TEXT_1159);
    }
    stringBuffer.append(TEXT_1160);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1162);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1165);
    }
    stringBuffer.append(TEXT_1166);
    }
    stringBuffer.append(TEXT_1167);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1170);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) { List allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList());
    stringBuffer.append(TEXT_1171);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1174);
    }
    stringBuffer.append(TEXT_1175);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1178);
    }
    stringBuffer.append(TEXT_1179);
    }
    }
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1180);
    { boolean first = true;
    for (Iterator i=genClass.getToStringGenFeatures().iterator(); i.hasNext(); ) { GenFeature genFeature = (GenFeature)i.next();
    if (first) { first = false;
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.isUnsettable() && !genFeature.isListType()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1188);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1191);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1192);
    }
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1196);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1199);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1200);
    }
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(genFeature.getUpperName());
    if (!genFeature.isListType() && !genFeature.isReferenceType()){
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1205);
    }
    stringBuffer.append(TEXT_1206);
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1209);
    } else {
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1211);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1212);
    }
    if (isImplementation && genClass.isMapEntry()) { GenFeature keyFeature = genClass.getMapEntryKeyFeature(); GenFeature valueFeature = genClass.getMapEntryValueFeature();
    stringBuffer.append(TEXT_1213);
    if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1215);
    } else {
    stringBuffer.append(TEXT_1216);
    }
    stringBuffer.append(TEXT_1217);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1219);
    } else if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(keyFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1222);
    } else {
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(keyFeature.getImportedType());
    stringBuffer.append(TEXT_1224);
    }
    stringBuffer.append(TEXT_1225);
    if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1227);
    } else {
    stringBuffer.append(TEXT_1228);
    }
    stringBuffer.append(TEXT_1229);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1231);
    } else if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(valueFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1234);
    } else {
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(valueFeature.getImportedType());
    stringBuffer.append(TEXT_1236);
    }
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1240);
    }
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
    // TODO fix the space above
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_1242);
    return stringBuffer.toString();
  }
}
