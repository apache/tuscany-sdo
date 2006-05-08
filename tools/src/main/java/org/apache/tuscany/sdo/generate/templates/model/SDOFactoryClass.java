package org.apache.tuscany.sdo.generate.templates.model;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

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
  protected final String TEXT_32 = NL + "/**" + NL + " * The package namespace URI." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */";
  protected final String TEXT_33 = NL;
  protected final String TEXT_34 = " NAMESPACE_URI = \"";
  protected final String TEXT_35 = "\";";
  protected final String TEXT_36 = NL + NL + "/**" + NL + " * The package namespace name." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = " NAMESPACE_PREFIX = \"";
  protected final String TEXT_39 = "\";";
  protected final String TEXT_40 = NL + NL;
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = "int ";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\t" + NL + "\t" + NL + "\t/**" + NL + "\t * Creates the default factory implementation." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_46 = NL + NL + "\t/**" + NL + "\t * Creates an instance of the factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_47 = "()" + NL + "\t{" + NL + "\t\tsuper(NAMESPACE_URI, NAMESPACE_PREFIX);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_48 = " create(int typeNumber)" + NL + "\t{" + NL + "\t\tswitch (typeNumber)" + NL + "\t\t{";
  protected final String TEXT_49 = NL + "\t\t\t// TODO make sure we're supposed to ingore DOCUMENT_ROOT" + NL + "\t\t\tcase ";
  protected final String TEXT_50 = ": return (";
  protected final String TEXT_51 = ")create";
  protected final String TEXT_52 = "();";
  protected final String TEXT_53 = NL + "\t\t\tdefault:" + NL + "\t\t\t\treturn super.create(typeNumber);" + NL + "\t\t}" + NL + "\t}" + NL + NL;
  protected final String TEXT_54 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object createFromString(";
  protected final String TEXT_55 = " eDataType, String initialValue)" + NL + "\t{" + NL + "\t\tswitch (eDataType.getClassifierID())" + NL + "\t\t{";
  protected final String TEXT_56 = NL + "\t\t\tcase ";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ":" + NL + "\t\t\t\treturn create";
  protected final String TEXT_59 = "FromString(eDataType, initialValue);";
  protected final String TEXT_60 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"The datatype '\" + eDataType.getName() + \"' is not a valid classifier\");";
  protected final String TEXT_61 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String convertToString(";
  protected final String TEXT_62 = " eDataType, Object instanceValue)" + NL + "\t{" + NL + "\t\tswitch (eDataType.getClassifierID())" + NL + "\t\t{";
  protected final String TEXT_63 = NL + "\t\t\tcase ";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = ":" + NL + "\t\t\t\treturn convert";
  protected final String TEXT_66 = "ToString(eDataType, instanceValue);";
  protected final String TEXT_67 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"The datatype '\" + eDataType.getName() + \"' is not a valid classifier\");";
  protected final String TEXT_68 = NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_69 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_70 = " create";
  protected final String TEXT_71 = "()" + NL + "\t{";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = "super.create(";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL + "\t\t";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = "()";
  protected final String TEXT_81 = "{}";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "\t\treturn ";
  protected final String TEXT_84 = ";" + NL + "\t}" + NL + "\t" + NL + "\t// Following creates and initializes SDO metadata for the supported types." + NL + "\tprotected ";
  protected final String TEXT_85 = " ";
  protected final String TEXT_86 = "Type = null;" + NL + "\t" + NL + "\tpublic ";
  protected final String TEXT_87 = " get";
  protected final String TEXT_88 = "()" + NL + "\t{" + NL + "\t\t// TODO - kdk - verify how to generate quoteType...";
  protected final String TEXT_89 = "Type?" + NL + "\t\treturn ";
  protected final String TEXT_90 = "Type;" + NL + "    }";
  protected final String TEXT_91 = NL + NL + "\tprivate static boolean isInited = false;" + NL + "\t" + NL + "\tpublic static ";
  protected final String TEXT_92 = " init()" + NL + "\t{" + NL + "    \tif (isInited) return (";
  protected final String TEXT_93 = ")FactoryBase.getStaticFactory(";
  protected final String TEXT_94 = ".NAMESPACE_URI);" + NL + "    \t";
  protected final String TEXT_95 = " the";
  protected final String TEXT_96 = " = new ";
  protected final String TEXT_97 = "();" + NL + "    \tisInited = true;" + NL + "" + NL + "    \t// Initialize simple dependencies" + NL + "    \t";
  protected final String TEXT_98 = ".registerStaticTypes(";
  protected final String TEXT_99 = ".class);" + NL + "    \t";
  protected final String TEXT_100 = ".registerStaticTypes(";
  protected final String TEXT_101 = ".class);" + NL + "    \t" + NL + "    \t// Create package meta-data objects" + NL + "    \tthe";
  protected final String TEXT_102 = ".createMetaData();" + NL + "" + NL + "    \t// Initialize created meta-data" + NL + "    \tthe";
  protected final String TEXT_103 = ".initializeMetaData();" + NL + "" + NL + "    \t// Mark meta-data to indicate it can't be changed" + NL + "    \t//the";
  protected final String TEXT_104 = ".freeze(); //FB do we need to freeze / should we freeze ????" + NL + "" + NL + "    \treturn the";
  protected final String TEXT_105 = ";" + NL + "\t}" + NL + "  " + NL + "\tprivate boolean isCreated = false;" + NL + "" + NL + "\tpublic void createMetaData()" + NL + "\t{" + NL + "\t\tif (isCreated) return;" + NL + "\t\tisCreated = true;";
  protected final String TEXT_106 = NL + "  ";
  protected final String TEXT_107 = NL + "    ";
  protected final String TEXT_108 = "Type = createType(false, ";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\tcreateProperty(";
  protected final String TEXT_111 = ", ";
  protected final String TEXT_112 = "Type, ";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = ");";
  protected final String TEXT_115 = NL + "\t}" + NL + "\tprivate boolean isInitialized = false;" + NL + "" + NL + "\tpublic void initializeMetaData()" + NL + "\t{" + NL + "\t\tif (isInitialized) return;" + NL + "\t\tisInitialized = true;" + NL + "" + NL + "\t\t// Obtain other dependent packages" + NL + "\t\t";
  protected final String TEXT_116 = " theModelPackageImpl = (";
  protected final String TEXT_117 = ")FactoryBase.getStaticFactory(";
  protected final String TEXT_118 = ".NAMESPACE_URI);" + NL + "" + NL + "\t\t// Add supertypes to classes" + NL + "\t\t// Initialize classes and features; add operations and parameters";
  protected final String TEXT_119 = NL + "\t\t" + NL + "\t\tinitializeType(";
  protected final String TEXT_120 = "Type, ";
  protected final String TEXT_121 = ".class, \"";
  protected final String TEXT_122 = "\");";
  protected final String TEXT_123 = NL + "\t\tinitializeProperty((";
  protected final String TEXT_124 = ")";
  protected final String TEXT_125 = "Type.getProperties().get(";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = "), ";
  protected final String TEXT_128 = ", \"";
  protected final String TEXT_129 = "\", ";
  protected final String TEXT_130 = ", ";
  protected final String TEXT_131 = ", ";
  protected final String TEXT_132 = ", ";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = ", ";
  protected final String TEXT_135 = ", ";
  protected final String TEXT_136 = ", ";
  protected final String TEXT_137 = " , ";
  protected final String TEXT_138 = ");";
  protected final String TEXT_139 = NL + "\t\tinitializeProperty((";
  protected final String TEXT_140 = ")";
  protected final String TEXT_141 = "Type.getProperties().get(";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = "), ";
  protected final String TEXT_144 = ", \"";
  protected final String TEXT_145 = "\", ";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = ", ";
  protected final String TEXT_148 = ", ";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = ", ";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = "createXSDMetaData();" + NL + "\t}" + NL + "  " + NL + "\tprotected void createXSDMetaData()" + NL + "\t{" + NL + "\t\tsuper.createXSDMetaData();";
  protected final String TEXT_154 = NL + "\t\t// TODO - kdk - is the order right?  should kind, elementOnly be first" + NL + "\t\taddXSDMapping" + NL + "\t\t(";
  protected final String TEXT_155 = "Type," + NL + "\t\tnew String[] " + NL + "\t\t{" + NL + "\t\t\"name\", \"";
  protected final String TEXT_156 = "\"," + NL + "\t\t\"kind\", \"elementOnly\"" + NL + "\t\t});";
  protected final String TEXT_157 = NL + "\t\taddXSDMapping" + NL + "\t\t((";
  protected final String TEXT_158 = ")";
  protected final String TEXT_159 = "Type.getProperties().get(";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = ")," + NL + "\t\tnew String[]" + NL + "\t\t{" + NL + "\t\t\"kind\", \"element\"," + NL + "\t\t\"name\", \"";
  protected final String TEXT_162 = "\"" + NL + "\t\t});" + NL + "\t";
  protected final String TEXT_163 = NL;
  protected final String TEXT_164 = NL + "\t\t// TODO - kdk - how do I filter out mixed, xMLNSPrefixMap, and xSISchemaLocation without hardcoding it" + NL + "\t\t// TODO - kdk - can I hardcode ##targetNamespace?" + NL + "\t";
  protected final String TEXT_165 = NL + "\t\tcreateGlobalProperty" + NL + "\t\t(\"";
  protected final String TEXT_166 = "\", " + NL + "\t\t";
  protected final String TEXT_167 = ".get";
  protected final String TEXT_168 = "()," + NL + "\t\tnew String[] " + NL + "\t\t{" + NL + "\t\t\"kind\", \"element\"," + NL + "\t\t\"name\", \"";
  protected final String TEXT_169 = "\"," + NL + "\t\t\"namespace\", \"##targetNamespace\"" + NL + "\t\t});  " + NL + "\t";
  protected final String TEXT_170 = NL + "  }" + NL;
  protected final String TEXT_171 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_172 = " create";
  protected final String TEXT_173 = "(String literal)" + NL + "\t{";
  protected final String TEXT_174 = NL + "\t\t";
  protected final String TEXT_175 = " result = ";
  protected final String TEXT_176 = ".get(literal);" + NL + "\t\tif (result == null) throw new IllegalArgumentException(\"The value '\" + literal + \"' is not a valid enumerator of '\" + ";
  protected final String TEXT_177 = ".getName() + \"'\");";
  protected final String TEXT_178 = NL + "\t\treturn result;";
  protected final String TEXT_179 = NL + "\t\treturn new ";
  protected final String TEXT_180 = "(create";
  protected final String TEXT_181 = "(literal));";
  protected final String TEXT_182 = NL + "\t\treturn create";
  protected final String TEXT_183 = "(literal);";
  protected final String TEXT_184 = NL + "\t\treturn new ";
  protected final String TEXT_185 = "(";
  protected final String TEXT_186 = ".create";
  protected final String TEXT_187 = "(literal));";
  protected final String TEXT_188 = NL + "\t\treturn ";
  protected final String TEXT_189 = ".create";
  protected final String TEXT_190 = "(literal);";
  protected final String TEXT_191 = NL + "\t\treturn (";
  protected final String TEXT_192 = ")";
  protected final String TEXT_193 = ".createFromString(";
  protected final String TEXT_194 = ", literal);";
  protected final String TEXT_195 = NL + "\t\tif (literal == null) return null;" + NL + "\t\t";
  protected final String TEXT_196 = " result = new ";
  protected final String TEXT_197 = "();" + NL + "\t\tfor (";
  protected final String TEXT_198 = " stringTokenizer = new ";
  protected final String TEXT_199 = "(literal); stringTokenizer.hasMoreTokens(); )" + NL + "\t\t{" + NL + "\t\t\tString item = stringTokenizer.nextToken();";
  protected final String TEXT_200 = NL + "\t\t\tresult.add(create";
  protected final String TEXT_201 = "(item));";
  protected final String TEXT_202 = NL + "\t\t\tresult.add(create";
  protected final String TEXT_203 = "FromString(";
  protected final String TEXT_204 = ", item));";
  protected final String TEXT_205 = NL + "\t\t\tresult.add(";
  protected final String TEXT_206 = ".create";
  protected final String TEXT_207 = "(item));";
  protected final String TEXT_208 = NL + "\t\t\tresult.add(";
  protected final String TEXT_209 = ".createFromString(";
  protected final String TEXT_210 = ", item));";
  protected final String TEXT_211 = NL + "\t\t}" + NL + "\t\treturn result;";
  protected final String TEXT_212 = NL + "\t\tif (literal == null) return ";
  protected final String TEXT_213 = ";" + NL + "\t\t";
  protected final String TEXT_214 = " result = ";
  protected final String TEXT_215 = ";" + NL + "\t\tRuntimeException exception = null;";
  protected final String TEXT_216 = NL + "\t\ttry" + NL + "\t\t{";
  protected final String TEXT_217 = NL + "\t\t\tresult = create";
  protected final String TEXT_218 = "(literal);";
  protected final String TEXT_219 = NL + "\t\t\tresult = (";
  protected final String TEXT_220 = ")create";
  protected final String TEXT_221 = "FromString(";
  protected final String TEXT_222 = ", literal);";
  protected final String TEXT_223 = NL + "\t\t\tresult = ";
  protected final String TEXT_224 = ".create";
  protected final String TEXT_225 = "(literal);";
  protected final String TEXT_226 = NL + "\t\t\tresult = (";
  protected final String TEXT_227 = ")";
  protected final String TEXT_228 = ".createFromString(";
  protected final String TEXT_229 = ", literal);";
  protected final String TEXT_230 = NL + "\t\t\tif (";
  protected final String TEXT_231 = "result != null && ";
  protected final String TEXT_232 = ".INSTANCE.validate(";
  protected final String TEXT_233 = ", ";
  protected final String TEXT_234 = "new ";
  protected final String TEXT_235 = "(result)";
  protected final String TEXT_236 = "result";
  protected final String TEXT_237 = ", null, null))" + NL + "\t\t\t{" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tcatch (RuntimeException e)" + NL + "\t\t{" + NL + "\t\t\texception = e;" + NL + "\t\t}";
  protected final String TEXT_238 = NL + "\t\tif (";
  protected final String TEXT_239 = "result != null || ";
  protected final String TEXT_240 = "exception == null) return result;" + NL + "    " + NL + "\t\tthrow exception;";
  protected final String TEXT_241 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_242 = "();";
  protected final String TEXT_243 = NL + "\t\treturn ((";
  protected final String TEXT_244 = ")super.createFromString(";
  protected final String TEXT_245 = ", literal)).";
  protected final String TEXT_246 = "();";
  protected final String TEXT_247 = NL + "\t\treturn (";
  protected final String TEXT_248 = ")super.createFromString(";
  protected final String TEXT_249 = ", literal);";
  protected final String TEXT_250 = NL + "\t}" + NL;
  protected final String TEXT_251 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_252 = " create";
  protected final String TEXT_253 = "FromString(";
  protected final String TEXT_254 = " eDataType, String initialValue)" + NL + "\t{";
  protected final String TEXT_255 = NL + "\t\treturn create";
  protected final String TEXT_256 = "(initialValue);";
  protected final String TEXT_257 = NL + "\t\t";
  protected final String TEXT_258 = " result = ";
  protected final String TEXT_259 = ".get(initialValue);" + NL + "\t\tif (result == null) throw new IllegalArgumentException(\"The value '\" + initialValue + \"' is not a valid enumerator of '\" + eDataType.getName() + \"'\");";
  protected final String TEXT_260 = NL + "\t\treturn result;";
  protected final String TEXT_261 = NL + "\t\treturn (";
  protected final String TEXT_262 = ")create";
  protected final String TEXT_263 = "FromString(";
  protected final String TEXT_264 = ", initialValue);";
  protected final String TEXT_265 = NL + "\t\treturn (";
  protected final String TEXT_266 = ")";
  protected final String TEXT_267 = ".createFromString(";
  protected final String TEXT_268 = ", initialValue);";
  protected final String TEXT_269 = NL + "\t\treturn create";
  protected final String TEXT_270 = "(initialValue);";
  protected final String TEXT_271 = NL + "\t\tif (initialValue == null) return null;" + NL + "\t\t";
  protected final String TEXT_272 = " result = new ";
  protected final String TEXT_273 = "();" + NL + "\t\tfor (";
  protected final String TEXT_274 = " stringTokenizer = new ";
  protected final String TEXT_275 = "(initialValue); stringTokenizer.hasMoreTokens(); )" + NL + "\t\t{" + NL + "\t\t\tString item = stringTokenizer.nextToken();";
  protected final String TEXT_276 = NL + "\t\t\tresult.add(create";
  protected final String TEXT_277 = "FromString(";
  protected final String TEXT_278 = ", item));";
  protected final String TEXT_279 = NL + "\t\t\tresult.add(";
  protected final String TEXT_280 = ".createFromString(";
  protected final String TEXT_281 = ", item));";
  protected final String TEXT_282 = NL + "\t\t}" + NL + "\t\treturn result;";
  protected final String TEXT_283 = NL + "\t\treturn new ";
  protected final String TEXT_284 = "(create";
  protected final String TEXT_285 = "(initialValue));";
  protected final String TEXT_286 = NL + "\t\treturn create";
  protected final String TEXT_287 = "(initialValue);";
  protected final String TEXT_288 = NL + "\t\tif (initialValue == null) return null;" + NL + "\t\t";
  protected final String TEXT_289 = " result = null;" + NL + "\t\tRuntimeException exception = null;";
  protected final String TEXT_290 = NL + "\t\ttry" + NL + "\t\t{";
  protected final String TEXT_291 = NL + "\t\t\tresult = (";
  protected final String TEXT_292 = ")create";
  protected final String TEXT_293 = "FromString(";
  protected final String TEXT_294 = ", initialValue);";
  protected final String TEXT_295 = NL + "\t\t\tresult = (";
  protected final String TEXT_296 = ")";
  protected final String TEXT_297 = ".createFromString(";
  protected final String TEXT_298 = ", initialValue);";
  protected final String TEXT_299 = NL + "\t\t\tif (result != null && ";
  protected final String TEXT_300 = ".INSTANCE.validate(eDataType, result, null, null))" + NL + "\t\t\t{" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tcatch (RuntimeException e)" + NL + "\t\t{" + NL + "\t\t\texception = e;" + NL + "\t\t}";
  protected final String TEXT_301 = NL + "\t\tif (result != null || exception == null) return result;" + NL + "    " + NL + "\t\tthrow exception;";
  protected final String TEXT_302 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_303 = "();";
  protected final String TEXT_304 = NL + "\t\treturn (";
  protected final String TEXT_305 = ")super.createFromString(eDataType, initialValue);";
  protected final String TEXT_306 = NL + "\t}" + NL;
  protected final String TEXT_307 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String convert";
  protected final String TEXT_308 = "(";
  protected final String TEXT_309 = " instanceValue)" + NL + "\t{";
  protected final String TEXT_310 = NL + "\t\treturn instanceValue == null ? null : instanceValue.toString();";
  protected final String TEXT_311 = NL + "\t\treturn instanceValue == null ? null : convert";
  protected final String TEXT_312 = "(instanceValue.";
  protected final String TEXT_313 = "());";
  protected final String TEXT_314 = NL + "\t\treturn convert";
  protected final String TEXT_315 = "(instanceValue);";
  protected final String TEXT_316 = NL + "\t\treturn ";
  protected final String TEXT_317 = ".convert";
  protected final String TEXT_318 = "(instanceValue);";
  protected final String TEXT_319 = NL + "\t\treturn ";
  protected final String TEXT_320 = ".convertToString(";
  protected final String TEXT_321 = ", instanceValue);";
  protected final String TEXT_322 = NL + "\t\tif (instanceValue == null) return null;" + NL + "\t\tif (instanceValue.isEmpty()) return \"\";" + NL + "\t\t";
  protected final String TEXT_323 = " result = new ";
  protected final String TEXT_324 = "();" + NL + "\t\tfor (";
  protected final String TEXT_325 = " i = instanceValue.iterator(); i.hasNext(); )" + NL + "\t\t{";
  protected final String TEXT_326 = NL + "\t\t\tresult.append(convert";
  protected final String TEXT_327 = "((";
  protected final String TEXT_328 = ")i.next()));";
  protected final String TEXT_329 = NL + "\t\t\tresult.append(convert";
  protected final String TEXT_330 = "ToString(";
  protected final String TEXT_331 = ", i.next()));";
  protected final String TEXT_332 = NL + "\t\t\tresult.append(";
  protected final String TEXT_333 = ".convert";
  protected final String TEXT_334 = "((";
  protected final String TEXT_335 = ")i.next()));";
  protected final String TEXT_336 = NL + "\t\t\tresult.append(";
  protected final String TEXT_337 = ".convertToString(";
  protected final String TEXT_338 = ", i.next()));";
  protected final String TEXT_339 = NL + "\t\t\tresult.append(' ');" + NL + "\t\t}" + NL + "\t\treturn result.substring(0, result.length() - 1);";
  protected final String TEXT_340 = NL + "\t\tif (instanceValue == null) return null;";
  protected final String TEXT_341 = NL + "\t\tif (";
  protected final String TEXT_342 = ".isInstance(instanceValue))" + NL + "\t\t{" + NL + "\t\t\ttry" + NL + "\t\t\t{";
  protected final String TEXT_343 = NL + "\t\t\t\tString value = convert";
  protected final String TEXT_344 = "(instanceValue);";
  protected final String TEXT_345 = NL + "\t\t\t\tString value = convert";
  protected final String TEXT_346 = "ToString(";
  protected final String TEXT_347 = ", instanceValue);";
  protected final String TEXT_348 = NL + "\t\t\t\tString value = ";
  protected final String TEXT_349 = ".convert";
  protected final String TEXT_350 = "((";
  protected final String TEXT_351 = ")instanceValue);";
  protected final String TEXT_352 = NL + "\t\t\t\tString value = ";
  protected final String TEXT_353 = ".convertToString(";
  protected final String TEXT_354 = ", instanceValue);";
  protected final String TEXT_355 = NL + "\t\t\t\tif (value != null) return value;" + NL + "\t\t\t}" + NL + "\t\t\tcatch (Exception e)" + NL + "\t\t\t{" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_356 = NL + "\t\ttry" + NL + "\t\t{";
  protected final String TEXT_357 = NL + "\t\t\tString value = convert";
  protected final String TEXT_358 = "(instanceValue);";
  protected final String TEXT_359 = NL + "\t\t\tString value = convert";
  protected final String TEXT_360 = "ToString(";
  protected final String TEXT_361 = ", new ";
  protected final String TEXT_362 = "(instanceValue));";
  protected final String TEXT_363 = NL + "\t\t\tString value = ";
  protected final String TEXT_364 = ".convert";
  protected final String TEXT_365 = "(instanceValue);";
  protected final String TEXT_366 = NL + "\t\t\tString value = ";
  protected final String TEXT_367 = ".convertToString(";
  protected final String TEXT_368 = ", new ";
  protected final String TEXT_369 = "(instanceValue));";
  protected final String TEXT_370 = NL + "\t\t\tif (value != null) return value;" + NL + "\t\t}" + NL + "\t\tcatch (Exception e)" + NL + "\t\t{" + NL + "\t\t}";
  protected final String TEXT_371 = NL + "\t\tthrow new IllegalArgumentException(\"Invalid value: '\"+instanceValue+\"' for datatype :\"+";
  protected final String TEXT_372 = ".getName());";
  protected final String TEXT_373 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_374 = "();";
  protected final String TEXT_375 = NL + "\t\treturn super.convertToString(";
  protected final String TEXT_376 = ", new ";
  protected final String TEXT_377 = "(instanceValue));";
  protected final String TEXT_378 = NL + "\t\treturn super.convertToString(";
  protected final String TEXT_379 = ", instanceValue);";
  protected final String TEXT_380 = NL + "\t}" + NL;
  protected final String TEXT_381 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String convert";
  protected final String TEXT_382 = "ToString(";
  protected final String TEXT_383 = " eDataType, Object instanceValue)" + NL + "\t{";
  protected final String TEXT_384 = NL + "\t\treturn instanceValue == null ? null : instanceValue.toString();";
  protected final String TEXT_385 = NL + "\t\treturn convert";
  protected final String TEXT_386 = "ToString(";
  protected final String TEXT_387 = ", instanceValue);";
  protected final String TEXT_388 = NL + "\t\treturn ";
  protected final String TEXT_389 = ".convertToString(";
  protected final String TEXT_390 = ", instanceValue);";
  protected final String TEXT_391 = NL + "\t\treturn convert";
  protected final String TEXT_392 = "((";
  protected final String TEXT_393 = ")instanceValue);";
  protected final String TEXT_394 = NL + "\t\tif (instanceValue == null) return null;" + NL + "\t\t";
  protected final String TEXT_395 = " list = (";
  protected final String TEXT_396 = ")instanceValue;" + NL + "\t\tif (list.isEmpty()) return \"\";" + NL + "\t\t";
  protected final String TEXT_397 = " result = new ";
  protected final String TEXT_398 = "();" + NL + "\t\tfor (";
  protected final String TEXT_399 = " i = list.iterator(); i.hasNext(); )" + NL + "\t\t{";
  protected final String TEXT_400 = NL + "\t\t\tresult.append(convert";
  protected final String TEXT_401 = "ToString(";
  protected final String TEXT_402 = ", i.next()));";
  protected final String TEXT_403 = NL + "\t\t\tresult.append(";
  protected final String TEXT_404 = ".convertToString(";
  protected final String TEXT_405 = ", i.next()));";
  protected final String TEXT_406 = NL + "\t\t\tresult.append(' ');" + NL + "\t\t}" + NL + "\t\treturn result.substring(0, result.length() - 1);";
  protected final String TEXT_407 = NL + "\t\treturn instanceValue == null ? null : convert";
  protected final String TEXT_408 = "(((";
  protected final String TEXT_409 = ")instanceValue).";
  protected final String TEXT_410 = "());";
  protected final String TEXT_411 = NL + "\t\treturn convert";
  protected final String TEXT_412 = "(instanceValue);";
  protected final String TEXT_413 = NL + "\t\tif (instanceValue == null) return null;";
  protected final String TEXT_414 = NL + "\t\tif (";
  protected final String TEXT_415 = ".isInstance(instanceValue))" + NL + "\t\t{" + NL + "\t\t\ttry" + NL + "\t\t\t{";
  protected final String TEXT_416 = NL + "\t\t\t\tString value = convert";
  protected final String TEXT_417 = "ToString(";
  protected final String TEXT_418 = ", instanceValue);";
  protected final String TEXT_419 = NL + "\t\t\t\tString value = ";
  protected final String TEXT_420 = ".convertToString(";
  protected final String TEXT_421 = ", instanceValue);";
  protected final String TEXT_422 = NL + "\t\t\t\tif (value != null) return value;" + NL + "\t\t\t}" + NL + "\t\t\tcatch (Exception e)" + NL + "\t\t\t{" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_423 = NL + "\t\tthrow new IllegalArgumentException(\"Invalid value: '\"+instanceValue+\"' for datatype :\"+eDataType.getName());";
  protected final String TEXT_424 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new ";
  protected final String TEXT_425 = "();";
  protected final String TEXT_426 = NL + "\t\treturn super.convertToString(eDataType, instanceValue);";
  protected final String TEXT_427 = NL + "\t}" + NL;
  protected final String TEXT_428 = NL + "\t/**" + NL + "\t * Returns a new object of class '<em>";
  protected final String TEXT_429 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return a new object of class '<em>";
  protected final String TEXT_430 = "</em>'." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_431 = " create";
  protected final String TEXT_432 = "();" + NL;
  protected final String TEXT_433 = NL + "\t/**" + NL + "\t * Returns an instance of data type '<em>";
  protected final String TEXT_434 = "</em>' corresponding the given literal." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param literal a literal of the data type." + NL + "\t * @return a new instance value of the data type." + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_435 = " create";
  protected final String TEXT_436 = "(String literal);" + NL + "" + NL + "\t/**" + NL + "\t * Returns a literal representation of an instance of data type '<em>";
  protected final String TEXT_437 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param instanceValue an instance value of the data type." + NL + "\t * @return a literal representation of the instance value." + NL + "\t * @generated" + NL + "\t */" + NL + "\tString convert";
  protected final String TEXT_438 = "(";
  protected final String TEXT_439 = " instanceValue);" + NL;
  protected final String TEXT_440 = NL + "} //";
  protected final String TEXT_441 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
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
    stringBuffer.append(TEXT_33);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genPackage.getNSName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_40);
    for (Iterator i=genPackage.getOrderedGenClassifiers().iterator(); i.hasNext();) { GenClassifier genClassifier = (GenClassifier)i.next();
    if (!genClassifier.getClassifierID().equals("DOCUMENT_ROOT")) { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genPackage.getClassifierID(genClassifier));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genPackage.getClassifierValue(genClassifier));
    stringBuffer.append(TEXT_44);
    } }
    stringBuffer.append(TEXT_45);
    String factoryType = genModel.isSuppressEMFMetaData() ? genPackage.getFactoryClassName() : genPackage.getImportedFactoryInterfaceName();
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genPackage.getFactoryClassName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.DataObject"));
    stringBuffer.append(TEXT_48);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && !genClass.getClassifierID().equals("DOCUMENT_ROOT")) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genClass.getClassifierID());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.DataObject"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_52);
    }
    }
    stringBuffer.append(TEXT_53);
    if (!genPackage.getAllGenDataTypes().isEmpty()) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
    stringBuffer.append(TEXT_55);
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genDataType.getClassifierID());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_59);
    }
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
    stringBuffer.append(TEXT_62);
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genDataType.getClassifierID());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_66);
    }
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_68);
    }
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && !genClass.getClassifierID().equals("DOCUMENT_ROOT")) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_71);
    if (genClass.isDynamic()) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genClass.getCastFromEObject());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_76);
    } else {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genClass.getImportedClassName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genClass.getImportedClassName());
    stringBuffer.append(TEXT_80);
    if (genModel.isSuppressInterfaces() && !genPackage.getReflectionPackageName().equals(genPackage.getInterfacePackageName())) {
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Type"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_90);
    }
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.util.SDOUtil"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.impl.SDOFactoryImpl"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.util.SDOUtil"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.model.impl.ModelPackageImpl"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(factoryType);
    stringBuffer.append(TEXT_105);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    stringBuffer.append(TEXT_106);
    if (!genClass.isAbstract() && !genClass.getClassifierID().equals("DOCUMENT_ROOT")) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(genPackage.getClassifierID(genClass));
    stringBuffer.append(TEXT_109);
    for (Iterator j=genClass.getAllGenFeatures().iterator(); j.hasNext();) { GenFeature genFeature = (GenFeature)j.next();
    stringBuffer.append(TEXT_110);
    stringBuffer.append(!genFeature.isReferenceType());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_114);
    }
    }
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.model.impl.ModelFactoryImpl"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.model.impl.ModelFactoryImpl"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genModel.getImportedName("org.apache.tuscany.sdo.model.impl.ModelFactoryImpl"));
    stringBuffer.append(TEXT_118);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && !genClass.getClassifierID().equals("DOCUMENT_ROOT")) {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_122);
    for (Iterator j=genClass.getAllGenFeatures().iterator(); j.hasNext();) {GenFeature genFeature = (GenFeature)j.next();
    String type = genFeature.getImportedType().equals("Sequence") ? "getSequence()" : genPackage.getPackageInstanceVariable(genFeature.getTypeGenPackage()) + ".get" + genFeature.getTypeClassifierAccessorName() + "()";
    if (genFeature.isReferenceType()) { GenFeature reverseGenFeature = genFeature.getReverse();
    String reverse = reverseGenFeature == null ? "null" : genPackage.getPackageInstanceVariable(reverseGenFeature.getGenPackage()) + ".get" + reverseGenFeature.getFeatureAccessorName() + "()";
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Property"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genFeature.getLowerBound());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(genFeature.getUpperBound());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genFeature.getContainerClass());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genFeature.getChangeableFlag().equals("IS_CHANGEABLE") ? "false" : "true");
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getUnsettableFlag().equals("IS_UNSETTABLE") ? "true": "false");
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genFeature.getDerivedFlag().equals("IS_DERIVED") ? "true" : "false");
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genFeature.getContainmentFlag().equals("IS_COMPOSITE")? "true": "false");
    stringBuffer.append(TEXT_137);
    stringBuffer.append(reverse);
    stringBuffer.append(TEXT_138);
    }else{
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Property"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genFeature.getLowerBound());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genFeature.getUpperBound());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genFeature.getContainerClass());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genFeature.getChangeableFlag().equals("IS_CHANGEABLE") ? "false" : "true");
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genFeature.getUnsettableFlag().equals("IS_UNSETTABLE") ? "true": "false");
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genFeature.getDerivedFlag().equals("IS_DERIVED") ? "true" : "false");
    stringBuffer.append(TEXT_152);
    }
    }
    }
    }
    stringBuffer.append(TEXT_153);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && !genClass.getClassifierID().equals("DOCUMENT_ROOT")) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_156);
    for (Iterator j=genClass.getAllGenFeatures().iterator(); j.hasNext();) { GenFeature genFeature = (GenFeature)j.next();
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genModel.getImportedName("commonj.sdo.Property"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_162);
    }
    }
    }
    stringBuffer.append(TEXT_163);
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (!genClass.isAbstract() && genClass.getClassifierID().equals("DOCUMENT_ROOT")) {
    stringBuffer.append(TEXT_164);
    for (Iterator j=genClass.getAllGenFeatures().iterator(); j.hasNext();) { GenFeature genFeature = (GenFeature)j.next();
    if (!genFeature.getName().equals("mixed") && !genFeature.getName().equals("xMLNSPrefixMap") && !genFeature.getName().equals("xSISchemaLocation")){ 
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genPackage.getPackageInstanceVariable(genFeature.getTypeGenPackage()));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genFeature.getTypeClassifierAccessorName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_169);
    }
    }
    }
    }
    stringBuffer.append(TEXT_170);
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    if (genPackage.isDataTypeConverters()) { String eDataType = genDataType.getQualifiedClassifierAccessor();
    stringBuffer.append(TEXT_171);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_173);
    if (genDataType instanceof GenEnum) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(genModel.getNonNLS(3));
    stringBuffer.append(TEXT_178);
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); boolean isPrimitiveConversion = !genDataType.isPrimitiveType() && genBaseType.isPrimitiveType();
    if (genBaseType.getGenPackage() == genPackage) {
    if (isPrimitiveConversion) {
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_181);
    } else {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_183);
    }
    } else if (genBaseType.getGenPackage().isDataTypeConverters()) {
    if (isPrimitiveConversion) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_187);
    } else {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_190);
    }
    } else {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_194);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_199);
    if (genItemType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_200);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_201);
    } else {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_204);
    }
    } else {
    if (genItemType.getGenPackage().isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_207);
    } else {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_210);
    }
    }
    stringBuffer.append(TEXT_211);
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(genDataType.getStaticValue(null));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(genDataType.getStaticValue(null));
    stringBuffer.append(TEXT_215);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_216);
    if (genMemberType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) { if (!genDataType.isPrimitiveType()) genMemberType = genMemberType.getObjectType();
    stringBuffer.append(TEXT_217);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_218);
    } else {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_222);
    }
    } else {
    if (genPackage.isDataTypeConverters()) { if (!genDataType.isPrimitiveType()) genMemberType = genMemberType.getObjectType();
    stringBuffer.append(TEXT_223);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_225);
    } else {
    stringBuffer.append(TEXT_226);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_229);
    }
    }
    stringBuffer.append(TEXT_230);
    if (!genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_231);
    }
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.Diagnostician"));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_233);
    if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_234);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_235);
    } else {
    stringBuffer.append(TEXT_236);
    }
    stringBuffer.append(TEXT_237);
    }
    stringBuffer.append(TEXT_238);
    if (!genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_239);
    }
    stringBuffer.append(TEXT_240);
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_241);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_242);
    } else if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_243);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_244);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genDataType.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_246);
    } else {
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_249);
    }
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_252);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
    stringBuffer.append(TEXT_254);
    if (genDataType instanceof GenEnum) {
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_255);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_256);
    } else {
    stringBuffer.append(TEXT_257);
    stringBuffer.append(((GenEnum)genDataType).getImportedInstanceClassName());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(((GenEnum)genDataType).getImportedInstanceClassName());
    stringBuffer.append(TEXT_259);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(genModel.getNonNLS(3));
    stringBuffer.append(TEXT_260);
    }
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); 
    if (genBaseType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_261);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_264);
    } else {
    stringBuffer.append(TEXT_265);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_268);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_270);
    } else {
    stringBuffer.append(TEXT_271);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(genModel.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(genModel.getImportedName("java.util.StringTokenizer"));
    stringBuffer.append(TEXT_275);
    if (genItemType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_278);
    } else {
    stringBuffer.append(TEXT_279);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    }
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    if (genPackage.isDataTypeConverters()) {
    if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_283);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_285);
    } else {
    stringBuffer.append(TEXT_286);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_287);
    }
    } else {
    stringBuffer.append(TEXT_288);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_289);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_290);
    if (genMemberType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_291);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_294);
    } else {
    stringBuffer.append(TEXT_295);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_297);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_298);
    }
    stringBuffer.append(TEXT_299);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.Diagnostician"));
    stringBuffer.append(TEXT_300);
    }
    stringBuffer.append(TEXT_301);
    }
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_302);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_303);
    } else {
    stringBuffer.append(TEXT_304);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    if (genPackage.isDataTypeConverters()) { String eDataType = genDataType.getQualifiedClassifierAccessor();
    stringBuffer.append(TEXT_307);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_308);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_309);
    if (genDataType instanceof GenEnum) {
    stringBuffer.append(TEXT_310);
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); boolean isPrimitiveConversion = !genDataType.isPrimitiveType() && genBaseType.isPrimitiveType();
    if (genBaseType.getGenPackage() == genPackage) {
    if (isPrimitiveConversion) {
    stringBuffer.append(TEXT_311);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_312);
    stringBuffer.append(genBaseType.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_313);
    } else {
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_315);
    }
    } else if (genBaseType.getGenPackage().isDataTypeConverters()) {
    stringBuffer.append(TEXT_316);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_317);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_318);
    } else {
    stringBuffer.append(TEXT_319);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_320);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_321);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    stringBuffer.append(TEXT_322);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_324);
    stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_325);
    if (genItemType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_326);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(genItemType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_328);
    } else {
    stringBuffer.append(TEXT_329);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_330);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_331);
    }
    } else {
    if (genItemType.getGenPackage().isDataTypeConverters()) { genItemType = genItemType.getObjectType();
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_334);
    stringBuffer.append(genItemType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_335);
    } else {
    stringBuffer.append(TEXT_336);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_337);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_338);
    }
    }
    stringBuffer.append(TEXT_339);
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    if (!genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_340);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_341);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_342);
    if (genMemberType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_344);
    } else {
    stringBuffer.append(TEXT_345);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_347);
    }
    } else {
    if (genMemberType.getGenPackage().isDataTypeConverters()) { genMemberType = genMemberType.getObjectType();
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_349);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_350);
    stringBuffer.append(genMemberType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_351);
    } else {
    stringBuffer.append(TEXT_352);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_353);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_354);
    }
    }
    stringBuffer.append(TEXT_355);
    }
    } else {
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_356);
    if (genMemberType.getGenPackage() == genPackage) {
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_357);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_358);
    } else {
    stringBuffer.append(TEXT_359);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_360);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_361);
    stringBuffer.append(genMemberType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_362);
    }
    } else {
    if (genMemberType.getGenPackage().isDataTypeConverters()) {
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_365);
    } else {
    stringBuffer.append(TEXT_366);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_367);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_368);
    stringBuffer.append(genMemberType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_369);
    }
    }
    stringBuffer.append(TEXT_370);
    }
    }
    stringBuffer.append(TEXT_371);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_372);
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_373);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_374);
    } else if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_375);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_377);
    } else {
    stringBuffer.append(TEXT_378);
    stringBuffer.append(eDataType);
    stringBuffer.append(TEXT_379);
    }
    stringBuffer.append(TEXT_380);
    }
    stringBuffer.append(TEXT_381);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_382);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EDataType"));
    stringBuffer.append(TEXT_383);
    if (genDataType instanceof GenEnum) {
    stringBuffer.append(TEXT_384);
    } else if (genDataType.getBaseType() != null) { GenDataType genBaseType = genDataType.getBaseType(); 
    if (genBaseType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_385);
    stringBuffer.append(genBaseType.getName());
    stringBuffer.append(TEXT_386);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_387);
    } else {
    stringBuffer.append(TEXT_388);
    stringBuffer.append(genBaseType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(genBaseType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_390);
    }
    } else if (genDataType.getItemType() != null) { GenDataType genItemType = genDataType.getItemType(); 
    if (genPackage.isDataTypeConverters()) {
    stringBuffer.append(TEXT_391);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_392);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_393);
    } else {
    stringBuffer.append(TEXT_394);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_395);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_396);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_397);
    stringBuffer.append(genModel.getImportedName("java.lang.StringBuffer"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_399);
    if (genItemType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_400);
    stringBuffer.append(genItemType.getName());
    stringBuffer.append(TEXT_401);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_402);
    } else {
    stringBuffer.append(TEXT_403);
    stringBuffer.append(genItemType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_404);
    stringBuffer.append(genItemType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_405);
    }
    stringBuffer.append(TEXT_406);
    }
    } else if (!genDataType.getMemberTypes().isEmpty()) {
    if (genPackage.isDataTypeConverters()) {
    if (genDataType.isPrimitiveType()) {
    stringBuffer.append(TEXT_407);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_408);
    stringBuffer.append(genDataType.getObjectInstanceClassName());
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genDataType.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_410);
    } else {
    stringBuffer.append(TEXT_411);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_412);
    }
    } else {
    stringBuffer.append(TEXT_413);
    for (Iterator j = genDataType.getMemberTypes().iterator(); j.hasNext(); ) { GenDataType genMemberType = (GenDataType)j.next();
    stringBuffer.append(TEXT_414);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_415);
    if (genMemberType.getGenPackage() == genPackage) {
    stringBuffer.append(TEXT_416);
    stringBuffer.append(genMemberType.getName());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_418);
    } else {
    stringBuffer.append(TEXT_419);
    stringBuffer.append(genMemberType.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
    stringBuffer.append(TEXT_420);
    stringBuffer.append(genMemberType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_421);
    }
    stringBuffer.append(TEXT_422);
    }
    stringBuffer.append(TEXT_423);
    }
    } else if (genDataType.isArrayType()) {
    stringBuffer.append(TEXT_424);
    stringBuffer.append(genModel.getImportedName("java.lang.UnsupportedOperationException"));
    stringBuffer.append(TEXT_425);
    } else {
    stringBuffer.append(TEXT_426);
    }
    stringBuffer.append(TEXT_427);
    }
    }
    } else {
    for (Iterator i=genPackage.getGenClasses().iterator(); i.hasNext();) { GenClass genClass = (GenClass)i.next();
    if (genClass.hasFactoryInterfaceCreateMethod()) {
    stringBuffer.append(TEXT_428);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_429);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_430);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_431);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_432);
    }
    }
    if (genPackage.isDataTypeConverters()) {
    for (Iterator i=genPackage.getAllGenDataTypes().iterator(); i.hasNext();) { GenDataType genDataType = (GenDataType)i.next();
    if (genDataType.isSerializable()) {
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_434);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_436);
    stringBuffer.append(genDataType.getFormattedName());
    stringBuffer.append(TEXT_437);
    stringBuffer.append(genDataType.getName());
    stringBuffer.append(TEXT_438);
    stringBuffer.append(genDataType.getImportedInstanceClassName());
    stringBuffer.append(TEXT_439);
    }
    }
    }
    }
    stringBuffer.append(TEXT_440);
    stringBuffer.append(isInterface ? genPackage.getFactoryInterfaceName() : genPackage.getFactoryClassName());
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_441);
    return stringBuffer.toString();
  }
}
