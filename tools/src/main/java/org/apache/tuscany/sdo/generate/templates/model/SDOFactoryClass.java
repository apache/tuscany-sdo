package org.apache.tuscany.sdo.generate.templates.model;

import org.apache.tuscany.sdo.generate.util.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.Literals;
import org.eclipse.emf.ecore.util.*;

public class SDOFactoryClass
{
  protected static String nl;
  public static synchronized SDOFactoryClass create(String lineSeparator)
  {
    nl = lineSeparator;
    SDOFactoryClass result = new SDOFactoryClass();
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
  protected final String TEXT_11 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Factory</b> for the model." + NL + " * It provides a create method for each non-abstract class of the model." + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_12 = NL + " * @see ";
  protected final String TEXT_13 = NL + " * @generated" + NL + " */";
  protected final String TEXT_14 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model <b>Factory</b>." + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */";
  protected final String TEXT_15 = NL + "public class ";
  protected final String TEXT_16 = " extends ";
  protected final String TEXT_17 = " implements ";
  protected final String TEXT_18 = NL + "public interface ";
  protected final String TEXT_19 = " extends ";
  protected final String TEXT_20 = NL + "{";
  protected final String TEXT_21 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_22 = " copyright = \"";
  protected final String TEXT_23 = "\";";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t/**" + NL + "\t * The singleton instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_27 = " INSTANCE = ";
  protected final String TEXT_28 = ".init();" + NL;
  protected final String TEXT_29 = NL + "\t/**" + NL + "\t * The singleton instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_30 = " eINSTANCE = ";
  protected final String TEXT_31 = ".init();" + NL;
  protected final String TEXT_32 = NL + "\t/**" + NL + "\t * The package namespace URI." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_33 = " NAMESPACE_URI = \"";
  protected final String TEXT_34 = "\";";
  protected final String TEXT_35 = NL + NL + "\t/**" + NL + "\t * The package namespace name." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_36 = " NAMESPACE_PREFIX = \"";
  protected final String TEXT_37 = "\";";
  protected final String TEXT_38 = "\t" + NL + "\t";
  protected final String TEXT_39 = "int ";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\t";
  protected final String TEXT_43 = NL + "\t/**" + NL + "\t * Creates an instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_44 = "()" + NL + "\t{" + NL + "\t\tsuper(NAMESPACE_URI, NAMESPACE_PREFIX);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_45 = " create(int typeNumber)" + NL + "\t{" + NL + "\t\tswitch (typeNumber)" + NL + "\t\t{";
  protected final String TEXT_46 = NL + "\t\t\tcase ";
  protected final String TEXT_47 = ": return (";
  protected final String TEXT_48 = ")create";
  protected final String TEXT_49 = "();";
  protected final String TEXT_50 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn super.create(typeNumber);" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_51 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object createFromString(";
  protected final String TEXT_52 = " type, String initialValue, int propertyValue)" + NL + "\t{" + NL + "\t\tswitch (propertyValue)" + NL + "\t\t{";
  protected final String TEXT_53 = NL + "\t\t\tcase ";
  protected final String TEXT_54 = ":" + NL + "\t\t\t\treturn create";
  protected final String TEXT_55 = "FromString(type, initialValue);";
  protected final String TEXT_56 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"The datatype '\" + type.getName() + \"' is not a valid property value\");";
  protected final String TEXT_57 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String convertToString(";
  protected final String TEXT_58 = " type, Object instanceValue, int propertyValue)" + NL + "\t{" + NL + "\t\tswitch (propertyValue)" + NL + "\t\t{";
  protected final String TEXT_59 = NL + "\t\t\tcase ";
  protected final String TEXT_60 = ":" + NL + "\t\t\t\treturn convert";
  protected final String TEXT_61 = "ToString(type, instanceValue);";
  protected final String TEXT_62 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"The datatype '\" + type.getName() + \"' is not a valid property value\");";
  protected final String TEXT_63 = NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_64 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_65 = " create";
  protected final String TEXT_66 = "()" + NL + "\t{";
  protected final String TEXT_67 = NL + "\t\t";
  protected final String TEXT_68 = " ";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = "super.create(";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = " = new ";
  protected final String TEXT_75 = "()";
  protected final String TEXT_76 = "{}";
  protected final String TEXT_77 = ";";
  protected final String TEXT_78 = NL + "\t\treturn ";
  protected final String TEXT_79 = ";" + NL + "\t}";
  protected final String TEXT_80 = NL + "\t" + NL + "\t// Following creates and initializes SDO metadata for the supported types.";
  protected final String TEXT_81 = "\t";
  protected final String TEXT_82 = "\t" + NL + "\tprotected ";
  protected final String TEXT_83 = " ";
  protected final String TEXT_84 = "Type = null;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_85 = " get";
  protected final String TEXT_86 = "()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_87 = "Type;" + NL + "\t}" + NL;
  protected final String TEXT_88 = "\t" + NL + "" + NL + "\tprivate static boolean isInited = false;" + NL + "" + NL + "\tpublic static ";
  protected final String TEXT_89 = " init()" + NL + "\t{" + NL + "\t\tif (isInited) return (";
  protected final String TEXT_90 = ")FactoryBase.getStaticFactory(";
  protected final String TEXT_91 = ".NAMESPACE_URI);" + NL + "\t\t";
  protected final String TEXT_92 = " the";
  protected final String TEXT_93 = " = new ";
  protected final String TEXT_94 = "();" + NL + "\t\tisInited = true;" + NL + "" + NL + "\t\t// Initialize simple dependencies" + NL + "\t\t";
  protected final String TEXT_95 = ".registerStaticTypes(";
  protected final String TEXT_96 = ".class);" + NL + "\t\t";
  protected final String TEXT_97 = ".registerStaticTypes(";
  protected final String TEXT_98 = ".class);" + NL + "" + NL + "\t\t// Create package meta-data objects" + NL + "\t\tthe";
  protected final String TEXT_99 = ".createMetaData();" + NL + "" + NL + "\t\t// Initialize created meta-data" + NL + "\t\tthe";
  protected final String TEXT_100 = ".initializeMetaData();" + NL + "" + NL + "\t\t// Mark meta-data to indicate it can't be changed" + NL + "\t\t//the";
  protected final String TEXT_101 = ".freeze(); //FB do we need to freeze / should we freeze ????" + NL + "" + NL + "\t\treturn the";
  protected final String TEXT_102 = ";" + NL + "\t}" + NL + "  " + NL + "\tprivate boolean isCreated = false;" + NL + "" + NL + "\tpublic void createMetaData()" + NL + "\t{" + NL + "\t\tif (isCreated) return;" + NL + "\t\tisCreated = true;";
  protected final String TEXT_103 = "\t";
  protected final String TEXT_104 = NL;
  protected final String TEXT_105 = NL + "\t\t";
  protected final String TEXT_106 = "Type = createType(false, ";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "\t\tcreateProperty(";
  protected final String TEXT_109 = ", ";
  protected final String TEXT_110 = "Type, ";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "\t\t// Create enums" + NL + "\t\t// todo";
  protected final String TEXT_114 = NL + "\t\t";
  protected final String TEXT_115 = " = createEEnum(";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\t\t";
  protected final String TEXT_118 = "Type = createType(true, ";
  protected final String TEXT_119 = " );";
  protected final String TEXT_120 = NL + "\t}" + NL + "\t" + NL + "\tprivate boolean isInitialized = false;" + NL + "" + NL + "\tpublic void initializeMetaData()" + NL + "\t{" + NL + "\t\tif (isInitialized) return;" + NL + "\t\tisInitialized = true;";
  protected final String TEXT_121 = NL + NL + "\t\t// Obtain other dependent packages";
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = " ";
  protected final String TEXT_124 = " = (";
  protected final String TEXT_125 = ")FactoryBase.getStaticFactory(";
  protected final String TEXT_126 = ".NAMESPACE_URI);";
  protected final String TEXT_127 = NL + "\t\t";
  protected final String TEXT_128 = " property = null;" + NL + "" + NL + "\t\t// Add supertypes to classes";
  protected final String TEXT_129 = NL + "\t\taddSuperType(";
  protected final String TEXT_130 = "Type, ";
  protected final String TEXT_131 = "Type);";
  protected final String TEXT_132 = NL + NL + "\t\t// Initialize classes and features; add operations and parameters";
  protected final String TEXT_133 = NL + "\t\tinitializeType(";
  protected final String TEXT_134 = "Type, ";
  protected final String TEXT_135 = ".class, \"";
  protected final String TEXT_136 = "\");";
  protected final String TEXT_137 = NL + "\t\tsetInstanceProperty (";
  protected final String TEXT_138 = "Type, \"";
  protected final String TEXT_139 = "\", ";
  protected final String TEXT_140 = ", ";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL;
  protected final String TEXT_143 = NL + "\t\tproperty = (";
  protected final String TEXT_144 = ")";
  protected final String TEXT_145 = "Type.getProperties().get(";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\tinitializeProperty(property, ";
  protected final String TEXT_149 = ", \"";
  protected final String TEXT_150 = "\", ";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ", ";
  protected final String TEXT_153 = ", ";
  protected final String TEXT_154 = ", ";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = ", ";
  protected final String TEXT_157 = ", ";
  protected final String TEXT_158 = " , ";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "\t\tinitializeProperty(property, ";
  protected final String TEXT_161 = ", \"";
  protected final String TEXT_162 = "\", ";
  protected final String TEXT_163 = ", ";
  protected final String TEXT_164 = ", ";
  protected final String TEXT_165 = ", ";
  protected final String TEXT_166 = ", ";
  protected final String TEXT_167 = ", ";
  protected final String TEXT_168 = ", ";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "\t\tsetInstanceProperty (property, \"";
  protected final String TEXT_171 = "\", ";
  protected final String TEXT_172 = ", ";
  protected final String TEXT_173 = ");";
  protected final String TEXT_174 = NL;
  protected final String TEXT_175 = NL + "\t\t// Initialize data types";
  protected final String TEXT_176 = NL + "\t\tinitializeType(";
  protected final String TEXT_177 = "Type, ";
  protected final String TEXT_178 = ".class, \"";
  protected final String TEXT_179 = "\", ";
  protected final String TEXT_180 = ", ";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "\t\tsetInstanceProperty (";
  protected final String TEXT_183 = "Type, \"";
  protected final String TEXT_184 = "\", ";
  protected final String TEXT_185 = ", ";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL;
  protected final String TEXT_188 = NL + "\t\tcreateXSDMetaData(theModelPackageImpl);" + NL + "\t}" + NL + "\t  " + NL + "\tprotected void createXSDMetaData(ModelFactoryImpl theModelPackageImpl)" + NL + "\t{" + NL + "\t\tsuper.createXSDMetaData();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_189 = " property = null;" + NL + "\t\t";
  protected final String TEXT_190 = NL + "\t\taddXSDMapping" + NL + "\t\t  (new String[]" + NL + "\t\t\t {";
  protected final String TEXT_191 = NL + "\t\t\t ";
  protected final String TEXT_192 = ", ";
  protected final String TEXT_193 = NL + "\t\t\t });" + NL;
  protected final String TEXT_194 = NL + "\t\taddXSDMapping" + NL + "\t\t  (";
  protected final String TEXT_195 = "Type," + NL + "\t\t\t new String[] " + NL + "\t\t\t {";
  protected final String TEXT_196 = NL + "\t\t\t ";
  protected final String TEXT_197 = ", ";
  protected final String TEXT_198 = NL + "\t\t\t });" + NL;
  protected final String TEXT_199 = NL + "\t\tproperty = createGlobalProperty" + NL + "\t\t  (\"";
  protected final String TEXT_200 = "\"," + NL + "\t\t  ";
  protected final String TEXT_201 = ".get";
  protected final String TEXT_202 = "()," + NL + "\t\t\t new String[]" + NL + "\t\t\t {";
  protected final String TEXT_203 = NL + "\t\t\t ";
  protected final String TEXT_204 = ", ";
  protected final String TEXT_205 = NL + "\t\t\t }," + NL + "\t\t\t IS_ATTRIBUTE);";
  protected final String TEXT_206 = NL + "\t\t\t });";
  protected final String TEXT_207 = NL + "              ";
  protected final String TEXT_208 = NL + "\t\tsetInstanceProperty" + NL + "\t\t  (property," + NL + "\t\t\t \"";
  protected final String TEXT_209 = "\"," + NL + "\t\t\t ";
  protected final String TEXT_210 = ", ";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "                  ";
  protected final String TEXT_213 = "  ";
  protected final String TEXT_214 = NL + "\t\taddXSDMapping" + NL + "\t\t  ((";
  protected final String TEXT_215 = ")";
  protected final String TEXT_216 = "Type.getProperties().get(";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = ")," + NL + "\t\t\t new String[]" + NL + "\t\t\t {";
  protected final String TEXT_219 = NL + "\t\t\t ";
  protected final String TEXT_220 = ", ";
  protected final String TEXT_221 = NL + "\t\t\t });" + NL;
  protected final String TEXT_222 = NL + "  }" + NL + "  ";
  protected final String TEXT_223 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_224 = " create";
  protected final String TEXT_225 = "(String literal)" + NL + "\t{";
  protected final String TEXT_226 = NL + "\t\t";
  protected final String TEXT_227 = " result = ";
  protected final String TEXT_228 = ".get(literal);" + NL + "\t\tif (result == null) throw new IllegalArgumentException(\"The value '\" + literal + \"' is not a valid enumerator of '\" + ";
  protected final String TEXT_229 = ".getName() + \"'\");";
  protected final String TEXT_230 = NL + "\t\treturn result;";
  protected final String TEXT_231 = NL + "\t\treturn new ";
  protected final String TEXT_232 = "(create";
  protected final String TEXT_233 = "(literal));";
  protected final String TEXT_234 = NL + "\t\treturn create";
  protected final String TEXT_235 = "(literal);";
  protected final String TEXT_236 = NL + "\t\treturn new ";
  protected final String TEXT_237 = "(";
  protected final String TEXT_238 = ".create";
  protected final String TEXT_239 = "(literal));";
  protected final String TEXT_240 = NL + "\t\treturn ";
  protected final String TEXT_241 = ".create";
  protected final String TEXT_242 = "(literal);";
  protected final String TEXT_243 = NL + "\t\treturn (";
  protected final String TEXT_244 = ")";
  protected final String TEXT_245 = ".createFromString(";
  protected final String TEXT_246 = ", literal);";
  protected final String TEXT_247 = NL + "\t\tif (literal == null) return null;" + NL + "\t\t";
  protected final String TEXT_248 = " result = new ";
  protected final String TEXT_249 = "();" + NL + "\t\tfor (";
  protected final String TEXT_250 = " stringTokenizer = new ";
  protected final String TEXT_251 = "(literal); stringTokenizer.hasMoreTokens(); )" + NL + "\t\t{" + NL + "\t\t\tString item = stringTokenizer.nextToken();";
  protected final String TEXT_252 = NL + "\t\t\tresult.add(create";
  protected final String TEXT_253 = "(item));";
  protected final String TEXT_254 = NL + "\t\t\tresult.add(create";
  protected final String TEXT_255 = "FromString(";
  protected final String TEXT_256 = ", item));";
  protected final String TEXT_257 = NL + "\t\t\tresult.add(";
  protected final String TEXT_258 = ".create";
  protected final String TEXT_259 = "(item));";
  protected final String TEXT_260 = NL + "\t\t\tresult.add(";
  protected final String TEXT_261 = ".createFromString(";
  protected final String TEXT_262 = ", item));";
  protected final String TEXT_263 = NL + "\t\t}" + NL + "\t\treturn result;";
  protected final String TEXT_264 = NL + "\t\tif (literal == null) return ";
  protected final String TEXT_265 = ";" + NL + "\t\t";
  protected final String TEXT_266 = " result = ";
  protected final String TEXT_267 = ";" + NL + "\t\tRuntimeException exception = null;";
  protected final String TEXT_268 = NL + "\t\ttry" + NL + "\t\t{";
  protected final String TEXT_269 = NL + "\t\t\tresult = create";
  protected final String TEXT_270 = "(literal);";
  protected final String TEXT_271 = NL + "\t\t\tresult = (";
  protected final String TEXT_272 = ")create";
  protected final String TEXT_273 = "FromString(";
  protected final String TEXT_274 = ", literal);";
  protected final String TEXT_275 = NL + "\t\t\tresult = ";
  protected final String TEXT_276 = ".create";
  protected final String TEXT_277 = "(literal);";
  protected final String TEXT_278 = NL + "\t\t\tresult = (";
  protected final String TEXT_279 = ")";
  protected final String TEXT_280 = ".createFromString(";
  protected final String TEXT_281 = ", literal);";
  protected final String TEXT_282 = NL + "\t\t\tif (";
  protected final String TEXT_283 = "result != null && ";
  protected final String TEXT_284 = ".INSTANCE.validate(";
  protected final String TEXT_285 = ", ";
  protected final String TEXT_286 = "new ";
  protected final String TEXT_287 = "(result)";
  protected final String TEXT_288 = "result";
  protected final String TEXT_289 = ", null, null))" + NL + "\t\t\t{" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tcatch (RuntimeException e)" + NL + "\t\t{" + NL + "\t\t\texception = e;" + NL + "\t\t}";
  protected final String TEXT_290 = NL + "\t\tif (";
  protected final String TEXT_291 = "result != null || ";
  protected final String TEXT_292 = "exception == null) return result;" + NL + "    " + NL + "\t\tthrow exception;";
  protected final String TEXT_293 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_294 = "();";
  protected final String TEXT_295 = NL + "\t\treturn ((";
  protected final String TEXT_296 = ")super.createFromString(";
  protected final String TEXT_297 = ", literal)).";
  protected final String TEXT_298 = "();";
  protected final String TEXT_299 = NL + "\t\treturn (";
  protected final String TEXT_300 = ")super.createFromString(";
  protected final String TEXT_301 = ", literal);";
  protected final String TEXT_302 = NL + "\t}" + NL;
  protected final String TEXT_303 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_304 = " create";
  protected final String TEXT_305 = "FromString(";
  protected final String TEXT_306 = " type, String initialValue)" + NL + "\t{";
  protected final String TEXT_307 = NL + "\t\treturn create";
  protected final String TEXT_308 = "(initialValue);";
  protected final String TEXT_309 = NL + "\t\t";
  protected final String TEXT_310 = " result = ";
  protected final String TEXT_311 = ".get(initialValue);" + NL + "\t\tif (result == null) throw new IllegalArgumentException(\"The value '\" + initialValue + \"' is not a valid enumerator of '\" + type.getName() + \"'\");";
  protected final String TEXT_312 = NL + "\t\treturn result;";
  protected final String TEXT_313 = NL + "\t\treturn (";
  protected final String TEXT_314 = ")create";
  protected final String TEXT_315 = "FromString(";
  protected final String TEXT_316 = ", initialValue);";
  protected final String TEXT_317 = NL + "\t\treturn (";
  protected final String TEXT_318 = ")";
  protected final String TEXT_319 = ".createFromString(";
  protected final String TEXT_320 = ", initialValue);";
  protected final String TEXT_321 = NL + "\t\treturn create";
  protected final String TEXT_322 = "(initialValue);";
  protected final String TEXT_323 = NL + "\t\tif (initialValue == null) return null;" + NL + "\t\t";
  protected final String TEXT_324 = " result = new ";
  protected final String TEXT_325 = "();" + NL + "\t\tfor (";
  protected final String TEXT_326 = " stringTokenizer = new ";
  protected final String TEXT_327 = "(initialValue); stringTokenizer.hasMoreTokens(); )" + NL + "\t\t{" + NL + "\t\t\tString item = stringTokenizer.nextToken();";
  protected final String TEXT_328 = NL + "\t\t\tresult.add(create";
  protected final String TEXT_329 = "FromString(";
  protected final String TEXT_330 = ", item));";
  protected final String TEXT_331 = NL + "\t\t\tresult.add(";
  protected final String TEXT_332 = ".createFromString(";
  protected final String TEXT_333 = ", item));";
  protected final String TEXT_334 = NL + "\t\t}" + NL + "\t\treturn result;";
  protected final String TEXT_335 = NL + "\t\treturn new ";
  protected final String TEXT_336 = "(create";
  protected final String TEXT_337 = "(initialValue));";
  protected final String TEXT_338 = NL + "\t\treturn create";
  protected final String TEXT_339 = "(initialValue);";
  protected final String TEXT_340 = NL + "\t\tif (initialValue == null) return null;" + NL + "\t\t";
  protected final String TEXT_341 = " result = null;" + NL + "\t\tRuntimeException exception = null;";
  protected final String TEXT_342 = NL + "\t\ttry" + NL + "\t\t{";
  protected final String TEXT_343 = NL + "\t\t\tresult = (";
  protected final String TEXT_344 = ")create";
  protected final String TEXT_345 = "FromString(";
  protected final String TEXT_346 = ", initialValue);";
  protected final String TEXT_347 = NL + "\t\t\tresult = (";
  protected final String TEXT_348 = ")";
  protected final String TEXT_349 = ".createFromString(";
  protected final String TEXT_350 = ", initialValue);";
  protected final String TEXT_351 = NL + "\t\t\tif (result != null && ";
  protected final String TEXT_352 = ".INSTANCE.validate(type, result, null, null))" + NL + "\t\t\t{" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tcatch (RuntimeException e)" + NL + "\t\t{" + NL + "\t\t\texception = e;" + NL + "\t\t}";
  protected final String TEXT_353 = NL + "\t\tif (result != null || exception == null) return result;" + NL + "    " + NL + "\t\tthrow exception;";
  protected final String TEXT_354 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_355 = "();";
  protected final String TEXT_356 = NL + "\t\treturn (";
  protected final String TEXT_357 = ")super.createFromString(type, initialValue);";
  protected final String TEXT_358 = NL + "\t}" + NL;
  protected final String TEXT_359 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String convert";
  protected final String TEXT_360 = "(";
  protected final String TEXT_361 = " instanceValue)" + NL + "\t{";
  protected final String TEXT_362 = NL + "\t\treturn instanceValue == null ? null : instanceValue.toString();";
  protected final String TEXT_363 = NL + "\t\treturn instanceValue == null ? null : convert";
  protected final String TEXT_364 = "(instanceValue.";
  protected final String TEXT_365 = "());";
  protected final String TEXT_366 = NL + "\t\treturn convert";
  protected final String TEXT_367 = "(instanceValue);";
  protected final String TEXT_368 = NL + "\t\treturn ";
  protected final String TEXT_369 = ".convert";
  protected final String TEXT_370 = "(instanceValue);";
  protected final String TEXT_371 = NL + "\t\treturn ";
  protected final String TEXT_372 = ".convertToString(";
  protected final String TEXT_373 = ", instanceValue);";
  protected final String TEXT_374 = NL + "\t\tif (instanceValue == null) return null;" + NL + "\t\tif (instanceValue.isEmpty()) return \"\";" + NL + "\t\t";
  protected final String TEXT_375 = " result = new ";
  protected final String TEXT_376 = "();" + NL + "\t\tfor (";
  protected final String TEXT_377 = " i = instanceValue.iterator(); i.hasNext(); )" + NL + "\t\t{";
  protected final String TEXT_378 = NL + "\t\t\tresult.append(convert";
  protected final String TEXT_379 = "((";
  protected final String TEXT_380 = ")i.next()));";
  protected final String TEXT_381 = NL + "\t\t\tresult.append(convert";
  protected final String TEXT_382 = "ToString(";
  protected final String TEXT_383 = ", i.next()));";
  protected final String TEXT_384 = NL + "\t\t\tresult.append(";
  protected final String TEXT_385 = ".convert";
  protected final String TEXT_386 = "((";
  protected final String TEXT_387 = ")i.next()));";
  protected final String TEXT_388 = NL + "\t\t\tresult.append(";
  protected final String TEXT_389 = ".convertToString(";
  protected final String TEXT_390 = ", i.next()));";
  protected final String TEXT_391 = NL + "\t\t\tresult.append(' ');" + NL + "\t\t}" + NL + "\t\treturn result.substring(0, result.length() - 1);";
  protected final String TEXT_392 = NL + "\t\tif (instanceValue == null) return null;";
  protected final String TEXT_393 = NL + "\t\tif (";
  protected final String TEXT_394 = ".isInstance(instanceValue))" + NL + "\t\t{" + NL + "\t\t\ttry" + NL + "\t\t\t{";
  protected final String TEXT_395 = NL + "\t\t\t\tString value = convert";
  protected final String TEXT_396 = "(instanceValue);";
  protected final String TEXT_397 = NL + "\t\t\t\tString value = convert";
  protected final String TEXT_398 = "ToString(";
  protected final String TEXT_399 = ", instanceValue);";
  protected final String TEXT_400 = NL + "\t\t\t\tString value = ";
  protected final String TEXT_401 = ".convert";
  protected final String TEXT_402 = "((";
  protected final String TEXT_403 = ")instanceValue);";
  protected final String TEXT_404 = NL + "\t\t\t\tString value = ";
  protected final String TEXT_405 = ".convertToString(";
  protected final String TEXT_406 = ", instanceValue);";
  protected final String TEXT_407 = NL + "\t\t\t\tif (value != null) return value;" + NL + "\t\t\t}" + NL + "\t\t\tcatch (Exception e)" + NL + "\t\t\t{" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_408 = NL + "\t\ttry" + NL + "\t\t{";
  protected final String TEXT_409 = NL + "\t\t\tString value = convert";
  protected final String TEXT_410 = "(instanceValue);";
  protected final String TEXT_411 = NL + "\t\t\tString value = convert";
  protected final String TEXT_412 = "ToString(";
  protected final String TEXT_413 = ", new ";
  protected final String TEXT_414 = "(instanceValue));";
  protected final String TEXT_415 = NL + "\t\t\tString value = ";
  protected final String TEXT_416 = ".convert";
  protected final String TEXT_417 = "(instanceValue);";
  protected final String TEXT_418 = NL + "\t\t\tString value = ";
  protected final String TEXT_419 = ".convertToString(";
  protected final String TEXT_420 = ", new ";
  protected final String TEXT_421 = "(instanceValue));";
  protected final String TEXT_422 = NL + "\t\t\tif (value != null) return value;" + NL + "\t\t}" + NL + "\t\tcatch (Exception e)" + NL + "\t\t{" + NL + "\t\t}";
  protected final String TEXT_423 = NL + "\t\tthrow new IllegalArgumentException(\"Invalid value: '\"+instanceValue+\"' for datatype :\"+";
  protected final String TEXT_424 = ".getName());";
  protected final String TEXT_425 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_426 = "();";
  protected final String TEXT_427 = NL + "\t\treturn super.convertToString(";
  protected final String TEXT_428 = ", new ";
  protected final String TEXT_429 = "(instanceValue));";
  protected final String TEXT_430 = NL + "\t\treturn super.convertToString(";
  protected final String TEXT_431 = ", instanceValue);";
  protected final String TEXT_432 = NL + "\t}" + NL;
  protected final String TEXT_433 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String convert";
  protected final String TEXT_434 = "ToString(";
  protected final String TEXT_435 = " type, Object instanceValue)" + NL + "\t{";
  protected final String TEXT_436 = NL + "\t\treturn instanceValue == null ? null : instanceValue.toString();";
  protected final String TEXT_437 = NL + "\t\treturn convert";
  protected final String TEXT_438 = "ToString(";
  protected final String TEXT_439 = ", instanceValue);";
  protected final String TEXT_440 = NL + "\t\treturn ";
  protected final String TEXT_441 = ".convertToString(";
  protected final String TEXT_442 = ", instanceValue);";
  protected final String TEXT_443 = NL + "\t\treturn convert";
  protected final String TEXT_444 = "((";
  protected final String TEXT_445 = ")instanceValue);";
  protected final String TEXT_446 = NL + "\t\tif (instanceValue == null) return null;" + NL + "\t\t";
  protected final String TEXT_447 = " list = (";
  protected final String TEXT_448 = ")instanceValue;" + NL + "\t\tif (list.isEmpty()) return \"\";" + NL + "\t\t";
  protected final String TEXT_449 = " result = new ";
  protected final String TEXT_450 = "();" + NL + "\t\tfor (";
  protected final String TEXT_451 = " i = list.iterator(); i.hasNext(); )" + NL + "\t\t{";
  protected final String TEXT_452 = NL + "\t\t\tresult.append(convert";
  protected final String TEXT_453 = "ToString(";
  protected final String TEXT_454 = ", i.next()));";
  protected final String TEXT_455 = NL + "\t\t\tresult.append(";
  protected final String TEXT_456 = ".convertToString(";
  protected final String TEXT_457 = ", i.next()));";
  protected final String TEXT_458 = NL + "\t\t\tresult.append(' ');" + NL + "\t\t}" + NL + "\t\treturn result.substring(0, result.length() - 1);";
  protected final String TEXT_459 = NL + "\t\treturn instanceValue == null ? null : convert";
  protected final String TEXT_460 = "(((";
  protected final String TEXT_461 = ")instanceValue).";
  protected final String TEXT_462 = "());";
  protected final String TEXT_463 = NL + "\t\treturn convert";
  protected final String TEXT_464 = "(instanceValue);";
  protected final String TEXT_465 = NL + "\t\tif (instanceValue == null) return null;";
  protected final String TEXT_466 = NL + "\t\tif (";
  protected final String TEXT_467 = ".isInstance(instanceValue))" + NL + "\t\t{" + NL + "\t\t\ttry" + NL + "\t\t\t{";
  protected final String TEXT_468 = NL + "\t\t\t\tString value = convert";
  protected final String TEXT_469 = "ToString(";
  protected final String TEXT_470 = ", instanceValue);";
  protected final String TEXT_471 = NL + "\t\t\t\tString value = ";
  protected final String TEXT_472 = ".convertToString(";
  protected final String TEXT_473 = ", instanceValue);";
  protected final String TEXT_474 = NL + "\t\t\t\tif (value != null) return value;" + NL + "\t\t\t}" + NL + "\t\t\tcatch (Exception e)" + NL + "\t\t\t{" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_475 = NL + "\t\tthrow new IllegalArgumentException(\"Invalid value: '\"+instanceValue+\"' for datatype :\"+type.getName());";
  protected final String TEXT_476 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_477 = "();";
  protected final String TEXT_478 = NL + "\t\treturn super.convertToString(type, instanceValue);";
  protected final String TEXT_479 = NL + "\t}" + NL;
  protected final String TEXT_480 = NL + "\t/**" + NL + "\t * Returns a new object of class '<em>";
  protected final String TEXT_481 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return a new object of class '<em>";
  protected final String TEXT_482 = "</em>'." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_483 = " create";
  protected final String TEXT_484 = "();" + NL;
  protected final String TEXT_485 = NL + "\t/**" + NL + "\t * Returns an instance of data type '<em>";
  protected final String TEXT_486 = "</em>' corresponding the given literal." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param literal a literal of the data type." + NL + "\t * @return a new instance value of the data type." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_487 = " create";
  protected final String TEXT_488 = "(String literal);" + NL + "" + NL + "\t/**" + NL + "\t * Returns a literal representation of an instance of data type '<em>";
  protected final String TEXT_489 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param instanceValue an instance value of the data type." + NL + "\t * @return a literal representation of the instance value." + NL + "\t * @generated" + NL + "\t */" + NL + "\tString convert";
  protected final String TEXT_490 = "(";
  protected final String TEXT_491 = " instanceValue);" + NL;
  protected final String TEXT_492 = NL + "} //";
  protected final String TEXT_493 = NL;

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

    GenPackage genPackage = (GenPackage)((Object[])argument)[0]; GenModel genModel=genPackage.getGenModel();
    boolean isInterface = Boolean.TRUE.equals(((Object[])argument)[1]); boolean isImplementation = Boolean.TRUE.equals(((Object[])argument)[2]);
    String publicStaticFinalFlag = isImplementation ? "public static final " : "";
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_4);
    if (isInterface || genModel.isSuppressInterfaces()) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genPackage.getReflectionPackageName());
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genPackage.getClassPackageName());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    if (isImplementation) {
    if (!genPackage.hasJavaLangConflict() && !genPackage.hasInterfaceImplConflict() && !genPackage.getClassPackageName().equals(genPackage.getInterfacePackageName())) genModel.addImport(genPackage.getInterfacePackageName() + ".*");
    }
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_10);
    if (isInterface) {
    stringBuffer.append(TEXT_11);
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    }
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genPackage.getFactoryClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.impl.FactoryBase"));
    if (!genModel.isSuppressInterfaces()) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genPackage.getImportedFactoryInterfaceName());
    }
    } else {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genPackage.getFactoryInterfaceName());
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EFactory"));
    }
    }
    stringBuffer.append(TEXT_20);
    if (genModel.getCopyrightText() != null) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genModel.getCopyrightText());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    if (isInterface && genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genPackage.getFactoryInterfaceName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genPackage.getQualifiedFactoryClassName());
    stringBuffer.append(TEXT_28);
    } else if (isInterface && !genModel.isSuppressInterfaces()) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genPackage.getFactoryInterfaceName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genPackage.getQualifiedFactoryClassName());
    stringBuffer.append(TEXT_31);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genPackage.getNSName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genModel.getNonNLS());
    int genIndex = 1;
for (Iterator i=genPackage.getOrderedGenClassifiers().iterator(); i.hasNext();) { GenClassifier genClassifier = (GenClassifier)i.next();
    if (!genPackage.getClassifierID(genClassifier).equals("DOCUMENT_ROOT")) { 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genPackage.getClassifierID(genClassifier));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genIndex);
    stringBuffer.append(TEXT_41);
    genIndex++;
     } }
    stringBuffer.append(TEXT_42);
    String factoryType = genModel.isSuppressEMFMetaData() ? genPackage.getFactoryClassName() : genPackage.getImportedFactoryInterfaceName();
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genPackage.getFactoryClassName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.DataObject"));
    stringBuffer.append(TEXT_45);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && !genClass.isDynamic()) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genClass.getClassifierID());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.DataObject"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_49);
    }
    }
    stringBuffer.append(TEXT_50);
    if (!genPackage.getAllGenDataTypes().isEmpty()) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_52);
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genDataType.getClassifierID());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_55);
    }
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_58);
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genDataType.getClassifierID());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_61);
    }
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_63);
    }
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && !genClass.isDynamic()) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_66);
    if (genClass.isDynamic()) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genClass.getCastFromEObject());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_71);
    } else {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genClass.getImportedClassName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genClass.getImportedClassName());
    stringBuffer.append(TEXT_75);
    if (genModel.isSuppressInterfaces() && !genPackage.getReflectionPackageName().equals(genPackage.getInterfacePackageName())) {
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_79);
    }
    }
    stringBuffer.append(TEXT_80);
    for (Iterator i=genPackage.getOrderedGenClassifiers().iterator(); i.hasNext();) { GenClassifier genClassifier = (GenClassifier)i.next();
    stringBuffer.append(TEXT_81);
    if (!genPackage.getClassifierID(genClassifier).equals("DOCUMENT_ROOT")) { 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genClassifier.getSafeUncapName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genClassifier.getClassifierAccessorName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genClassifier.getSafeUncapName());
    stringBuffer.append(TEXT_87);
    } }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.util.SDOUtil"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.impl.SDOFactoryImpl"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.util.SDOUtil"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.model.impl.ModelPackageImpl"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_102);
    if (!genPackage.getGenClasses().isEmpty()) {
    stringBuffer.append(TEXT_103);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    stringBuffer.append(TEXT_104);
    if (!genClass.isAbstract() && !genClass.isDynamic()) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genPackage.getClassifierID(genClass));
    stringBuffer.append(TEXT_107);
    for (Iterator j=genClass.getGenFeatures().iterator(); j.hasNext();) { GenFeature genFeature = (GenFeature)j.next();
    stringBuffer.append(TEXT_108);
    stringBuffer.append(!genFeature.isReferenceType());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_112);
    }
    }
    }
    }
    if (!genPackage.getGenEnums().isEmpty()) {
    stringBuffer.append(TEXT_113);
    for (Iterator e=genPackage.getGenEnums().iterator(); e.hasNext();) { GenEnum genEnum = (GenEnum)e.next();
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genEnum.getClassifierInstanceName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genEnum.getClassifierID());
    stringBuffer.append(TEXT_116);
    }
    }
    if (!genPackage.getGenDataTypes().isEmpty()) {
    for (Iterator d=genPackage.getGenDataTypes().iterator(); d.hasNext();) { GenDataType genDataType = (GenDataType)d.next();
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genPackage.getClassifierID(genDataType));
    stringBuffer.append(TEXT_119);
    }
    }
    stringBuffer.append(TEXT_120);
    if (!genPackage.getPackageInitializationDependencies().isEmpty()) {
    stringBuffer.append(TEXT_121);
    for (Iterator p=genPackage.getPackageInitializationDependencies().iterator(); p.hasNext();) { GenPackage dep = (GenPackage)p.next();
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dep.getImportedFactoryClassName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genPackage.getPackageInstanceVariable(dep));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(dep.getImportedFactoryClassName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(dep.getImportedFactoryClassName());
    stringBuffer.append(TEXT_126);
    }
    }
    List annotationSources = genPackage.getAnnotationSources();
    annotationSources.remove(ExtendedMetaData.ANNOTATION_URI);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Property"));
    stringBuffer.append(TEXT_128);
    for (Iterator c=genPackage.getGenClasses().iterator(); c.hasNext();) { GenClass genClass = (GenClass)c.next();
    for (Iterator b=genClass.getBaseGenClasses().iterator(); b.hasNext();) { GenClass baseGenClass = (GenClass)b.next();
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(baseGenClass.getSafeUncapName());
    stringBuffer.append(TEXT_131);
    }
    }
    stringBuffer.append(TEXT_132);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && !genClass.isDynamic()) {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_136);
    for (Iterator sources = annotationSources.iterator(); sources.hasNext();) { String annotationSource = (String)sources.next();
    EAnnotation classAnnotation = genClass.getEcoreClassifier().getEAnnotation(annotationSource);
    if (classAnnotation != null) { 
    for (Iterator k = classAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(annotationSource);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(value);
    stringBuffer.append(genModel.getNonNLS(key + value));
    stringBuffer.append(TEXT_141);
    }
    }
    }
    stringBuffer.append(TEXT_142);
    for (Iterator j=genClass.getGenFeatures().iterator(); j.hasNext();) {GenFeature genFeature = (GenFeature)j.next();
    String type = genFeature.getType().equals("commonj.sdo.Sequence") ? "getSequence()" : genPackage.getPackageInstanceVariable(genFeature.getTypeGenPackage()) + ".get" + genFeature.getTypeClassifierAccessorName() + "()";
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Property"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_147);
    if (genFeature.isReferenceType()) { GenFeature reverseGenFeature = genFeature.getReverse();
    String reverse = reverseGenFeature == null ? "null" : genPackage.getPackageInstanceVariable(reverseGenFeature.getGenPackage()) + ".get" + reverseGenFeature.getFeatureAccessorName() + "()";
    stringBuffer.append(TEXT_148);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genFeature.getLowerBound());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genFeature.getUpperBound());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genFeature.getContainerClass());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(genFeature.getChangeableFlag().equals("IS_CHANGEABLE") ? "false" : "true");
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genFeature.getUnsettableFlag().equals("IS_UNSETTABLE") ? "true": "false");
    stringBuffer.append(TEXT_156);
    stringBuffer.append(genFeature.getDerivedFlag().equals("IS_DERIVED") ? "true" : "false");
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genFeature.getContainmentFlag().equals("IS_COMPOSITE")? "true": "false");
    stringBuffer.append(TEXT_158);
    stringBuffer.append(reverse);
    stringBuffer.append(TEXT_159);
    }else{
    stringBuffer.append(TEXT_160);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getLowerBound());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genFeature.getUpperBound());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genFeature.getContainerClass());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genFeature.getChangeableFlag().equals("IS_CHANGEABLE") ? "false" : "true");
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genFeature.getUnsettableFlag().equals("IS_UNSETTABLE") ? "true": "false");
    stringBuffer.append(TEXT_168);
    stringBuffer.append(genFeature.getDerivedFlag().equals("IS_DERIVED") ? "true" : "false");
    stringBuffer.append(TEXT_169);
    }
    for (Iterator sources = annotationSources.iterator(); sources.hasNext();) { String annotationSource = (String)sources.next();
    EAnnotation featureAnnotation = genFeature.getEcoreFeature().getEAnnotation(annotationSource);
    if (featureAnnotation != null) { 
    for (Iterator k = featureAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(annotationSource);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(value);
    stringBuffer.append(genModel.getNonNLS(key + value));
    stringBuffer.append(TEXT_173);
    }
    }
    }
    stringBuffer.append(TEXT_174);
    }
    }
    }
    if (!genPackage.getGenDataTypes().isEmpty()) {
    stringBuffer.append(TEXT_175);
    for (Iterator d=genPackage.getGenDataTypes().iterator(); d.hasNext();) { GenDataType genDataType = (GenDataType)d.next();
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genDataType.getSerializableFlag().equals("IS_SERIALIZABLE") ? "true" : "false");
    stringBuffer.append(TEXT_180);
    stringBuffer.append(genDataType.getGeneratedInstanceClassFlag().equals("IS_GENERATED_INSTANCE_CLASS") ? "true" : "false" );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(genModel.getNonNLS());
    for (Iterator sources = annotationSources.iterator(); sources.hasNext();) { String annotationSource = (String)sources.next();
    EAnnotation dataTypeAnnotation = genDataType.getEcoreDataType().getEAnnotation(annotationSource);
    if (dataTypeAnnotation != null) { 
    for (Iterator k = dataTypeAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(genDataType.getSafeUncapName());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(annotationSource);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(value);
    stringBuffer.append(genModel.getNonNLS(key + value));
    stringBuffer.append(TEXT_186);
    }
    }
    }
    stringBuffer.append(TEXT_187);
    }
    }
    stringBuffer.append(TEXT_188);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Property"));
    stringBuffer.append(TEXT_189);
    String extendedMetaDataSource = ExtendedMetaData.ANNOTATION_URI;
    EAnnotation packageAnnotation = genPackage.getEcorePackage().getEAnnotation(extendedMetaDataSource);
    if (packageAnnotation != null){ 
    stringBuffer.append(TEXT_190);
    for (Iterator k = packageAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(value);
    stringBuffer.append(k.hasNext() ? "," : "");
    stringBuffer.append(genModel.getNonNLS(key + value));
    }
    stringBuffer.append(TEXT_193);
    }
    for (Iterator i=genPackage.getGenClassifiers().iterator(); i.hasNext();) { GenClassifier genClassifier = (GenClassifier)i.next(); EAnnotation classAnnotation = genClassifier.getEcoreClassifier().getEAnnotation(extendedMetaDataSource);
    if (classAnnotation != null && !genClassifier.getName().equals("DocumentRoot")) {
    stringBuffer.append(TEXT_194);
    stringBuffer.append(genClassifier.getSafeUncapName());
    stringBuffer.append(TEXT_195);
    for (Iterator k = classAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(value);
    stringBuffer.append(k.hasNext() ? "," : "");
    stringBuffer.append(genModel.getNonNLS(key + value));
    }
    stringBuffer.append(TEXT_198);
    }
    if (genClassifier instanceof GenClass) { GenClass genClass = (GenClass) genClassifier;
    for (Iterator j=genClass.getGenFeatures().iterator(); j.hasNext();) { GenFeature genFeature = (GenFeature)j.next(); 
    EAnnotation featureAnnotation = genFeature.getEcoreFeature().getEAnnotation(extendedMetaDataSource);
    if (genClass.getName().equals("DocumentRoot")) { 
    if (!(genFeature.getName().equals("mixed") || genFeature.getName().equals("xMLNSPrefixMap") || genFeature.getName().equals("xSISchemaLocation"))) { 
    stringBuffer.append(TEXT_199);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genPackage.getPackageInstanceVariable(genFeature.getTypeGenPackage()));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(genFeature.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_202);
    for (Iterator k = featureAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(value);
    stringBuffer.append(k.hasNext() ? "," : "");
    stringBuffer.append(genModel.getNonNLS(key + value));
    }
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_205);
    } else {
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    for (Iterator sources = genPackage.getAnnotationSources().iterator(); sources.hasNext();) { String annotationSource = (String)sources.next(); 
    if (!annotationSource.equals(extendedMetaDataSource)) {
    EAnnotation globalAnnotation = genFeature.getEcoreFeature().getEAnnotation(annotationSource);
    if (globalAnnotation != null) {
    for (Iterator k = globalAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(annotationSource);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(value);
    stringBuffer.append(genModel.getNonNLS(key + value));
    stringBuffer.append(TEXT_211);
    }
    stringBuffer.append(TEXT_212);
    }
    }
    stringBuffer.append(TEXT_213);
    }
    }
    } else {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Property"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(genClassifier.getSafeUncapName());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_218);
    for (Iterator k = featureAnnotation.getDetails().iterator(); k.hasNext();) { Map.Entry detail = (Map.Entry)k.next(); String key = Literals.toStringLiteral((String)detail.getKey(), genModel); String value = Literals.toStringLiteral((String)detail.getValue(), genModel);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(value);
    stringBuffer.append(k.hasNext() ? "," : "");
    stringBuffer.append(genModel.getNonNLS(key + value));
    }
    stringBuffer.append(TEXT_221);
    }
    }
    }
    }
    stringBuffer.append(TEXT_222);
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    if (genPackage.isDataTypeConverters()) { String eDataType = genDataType.getQualifiedClassifierAccessor();
    stringBuffer.append(TEXT_223);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_225);
    if (genDataType instanceof GenEnum) {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(genModel.getNonNLS(3));
    stringBuffer.append(TEXT_230);
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); boolean isPrimitiveConversion = !genDataType.isPrimitiveType() && genBaseType.isPrimitiveType();
    if (genBaseType.getGenPackage() == genPackage) {
    if (isPrimitiveConversion) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_233);
    } else {
    stringBuffer.append(TEXT_234);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_235);
    }
    } else if (genBaseType.getGenPackage().isDataTypeConverters()) {
    if (isPrimitiveConversion) {
    stringBuffer.append(TEXT_236);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_239);
    } else {
    stringBuffer.append(TEXT_240);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_242);
    }
    } else {
    stringBuffer.append(TEXT_243);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_246);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_249);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_251);
    if (genItemType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_252);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_253);
    } else {
    stringBuffer.append(TEXT_254);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_256);
    }
    } else {
    if (genItemType.getGenPackage().isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_257);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_259);
    } else {
    stringBuffer.append(TEXT_260);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_261);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_262);
    }
    }
    stringBuffer.append(TEXT_263);
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    stringBuffer.append(TEXT_264);
    stringBuffer.append(genDataType.getStaticValue(null));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genDataType.getStaticValue(null));
    stringBuffer.append(TEXT_267);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_268);
    if (genMemberType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) { if (!genDataType.isPrimitiveType()) genMemberType = genMemberType.getObjectType();
    stringBuffer.append(TEXT_269);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_270);
    } else {
    stringBuffer.append(TEXT_271);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_274);
    }
    } else {
    if (genPackage.isDataTypeConverters()) { if (!genDataType.isPrimitiveType()) genMemberType = genMemberType.getObjectType();
    stringBuffer.append(TEXT_275);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_277);
    } else {
    stringBuffer.append(TEXT_278);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_281);
    }
    }
    stringBuffer.append(TEXT_282);
    if (!genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_283);
    }
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.Diagnostician"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_285);
    if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_286);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_287);
    } else {
    stringBuffer.append(TEXT_288);
    }
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    if (!genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_294);
    } else if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_295);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(genDataType.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_298);
    } else {
    stringBuffer.append(TEXT_299);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_301);
    }
    stringBuffer.append(TEXT_302);
    }
    stringBuffer.append(TEXT_303);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_304);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_305);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_306);
    if (genDataType instanceof GenEnum) {
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_307);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_308);
    } else {
    stringBuffer.append(TEXT_309);
    stringBuffer.append(((GenEnum)genDataType).getImportedInstanceClassName());
    stringBuffer.append(TEXT_310);
    stringBuffer.append(((GenEnum)genDataType).getImportedInstanceClassName());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(genModel.getNonNLS(3));
    stringBuffer.append(TEXT_312);
    }
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); 
    if (genBaseType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_313);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_315);
    stringBuffer.append(SDOGenUtil.getQualifiedTypeAccessor(genDataType));
    stringBuffer.append(TEXT_316);
    } else {
    stringBuffer.append(TEXT_317);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_318);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_319);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_320);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_321);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_322);
    } else {
    stringBuffer.append(TEXT_323);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_325);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_326);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_327);
    if (genItemType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_328);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_329);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_330);
    } else {
    stringBuffer.append(TEXT_331);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_333);
    }
    stringBuffer.append(TEXT_334);
    }
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    if (genPackage.isDataTypeConverters()) {
    if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_335);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_336);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_337);
    } else {
    stringBuffer.append(TEXT_338);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_339);
    }
    } else {
    stringBuffer.append(TEXT_340);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_341);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_342);
    if (genMemberType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_344);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_345);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_346);
    } else {
    stringBuffer.append(TEXT_347);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_349);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_350);
    }
    stringBuffer.append(TEXT_351);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.Diagnostician"));
    stringBuffer.append(TEXT_352);
    }
    stringBuffer.append(TEXT_353);
    }
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_354);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_355);
    } else {
    stringBuffer.append(TEXT_356);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_357);
    }
    stringBuffer.append(TEXT_358);
    if (genPackage.isDataTypeConverters()) { String eDataType = genDataType.getQualifiedClassifierAccessor();
    stringBuffer.append(TEXT_359);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_360);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_361);
    if (genDataType instanceof GenEnum) {
    stringBuffer.append(TEXT_362);
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); boolean isPrimitiveConversion = !genDataType.isPrimitiveType() && genBaseType.isPrimitiveType();
    if (genBaseType.getGenPackage() == genPackage) {
    if (isPrimitiveConversion) {
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(genBaseType.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_365);
    } else {
    stringBuffer.append(TEXT_366);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_367);
    }
    } else if (genBaseType.getGenPackage().isDataTypeConverters()) {
    stringBuffer.append(TEXT_368);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_369);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_370);
    } else {
    stringBuffer.append(TEXT_371);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_372);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_373);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    stringBuffer.append(TEXT_374);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_376);
    stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_377);
    if (genItemType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_378);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_379);
    stringBuffer.append(genItemType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_380);
    } else {
    stringBuffer.append(TEXT_381);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_382);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_383);
    }
    } else {
    if (genItemType.getGenPackage().isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_384);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_385);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_386);
    stringBuffer.append(genItemType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_387);
    } else {
    stringBuffer.append(TEXT_388);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_390);
    }
    }
    stringBuffer.append(TEXT_391);
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    if (!genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_392);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_393);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_394);
    if (genMemberType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_395);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_396);
    } else {
    stringBuffer.append(TEXT_397);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_398);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_399);
    }
    } else {
    if (genMemberType.getGenPackage().isDataTypeConverters()) { genMemberType = genMemberType.getObjectType();
    stringBuffer.append(TEXT_400);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_401);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_402);
    stringBuffer.append(genMemberType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_403);
    } else {
    stringBuffer.append(TEXT_404);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_405);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_406);
    }
    }
    stringBuffer.append(TEXT_407);
    }
    } else {
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_408);
    if (genMemberType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_410);
    } else {
    stringBuffer.append(TEXT_411);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_412);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_413);
    stringBuffer.append(genMemberType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_414);
    }
    } else {
    if (genMemberType.getGenPackage().isDataTypeConverters()) {
    stringBuffer.append(TEXT_415);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_416);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_417);
    } else {
    stringBuffer.append(TEXT_418);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_419);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(genMemberType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_421);
    }
    }
    stringBuffer.append(TEXT_422);
    }
    }
    stringBuffer.append(TEXT_423);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_424);
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_425);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_426);
    } else if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_427);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_429);
    } else {
    stringBuffer.append(TEXT_430);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_431);
    }
    stringBuffer.append(TEXT_432);
    }
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_434);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_435);
    if (genDataType instanceof GenEnum) {
    stringBuffer.append(TEXT_436);
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); 
    if (genBaseType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_437);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_438);
    stringBuffer.append(SDOGenUtil.getQualifiedTypeAccessor(genBaseType));
    stringBuffer.append(TEXT_439);
    } else {
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_441);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_442);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_443);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_444);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_445);
    } else {
    stringBuffer.append(TEXT_446);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_447);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_448);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_449);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_450);
    stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_451);
    if (genItemType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_452);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_454);
    } else {
    stringBuffer.append(TEXT_455);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_456);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_457);
    }
    stringBuffer.append(TEXT_458);
    }
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    if (genPackage.isDataTypeConverters()) {
    if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_459);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_460);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_461);
    stringBuffer.append(genDataType.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_462);
    } else {
    stringBuffer.append(TEXT_463);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_464);
    }
    } else {
    stringBuffer.append(TEXT_465);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_466);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_467);
    if (genMemberType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_468);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_469);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_470);
    } else {
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_472);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_473);
    }
    stringBuffer.append(TEXT_474);
    }
    stringBuffer.append(TEXT_475);
    }
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_476);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_477);
    } else {
    stringBuffer.append(TEXT_478);
    }
    stringBuffer.append(TEXT_479);
    }
    }
    } else {
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (genClass.hasFactoryInterfaceCreateMethod()) {
    stringBuffer.append(TEXT_480);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_481);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_482);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_483);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_484);
    }
    }
    if (genPackage.isDataTypeConverters()) {
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    stringBuffer.append(TEXT_485);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_486);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_487);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_488);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_489);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_490);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_491);
    }
    }
    }
    }
    stringBuffer.append(TEXT_492);
    stringBuffer.append(isInterface ? genPackage.getFactoryInterfaceName() : genPackage.getFactoryClassName());
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_493);
    return stringBuffer.toString();
  }
}
