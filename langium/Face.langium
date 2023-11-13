grammar Face
import 'Uddl'

entry ArchitectureModel infers ArchitectureModel:
    'am' name=ID  description=STRING  '{' (dm+=DataModel  | um+=UopUoPModel  | im+=IntegrationIntegrationModel  )+'}'  
;

FaceElement infers FaceElement:
    ArchitectureModel | UopUoPModel | IntegrationIntegrationModel | UopElement | IntegrationElement | IntegrationTransportNode 
;

type UoPClientServerRole = 'client' | 'server';
UoPClientServerRole returns UoPClientServerRole:
    UoPClientServerRole_CLIENT | UoPClientServerRole_SERVER
;
UoPClientServerRole_CLIENT returns string: 'client' ;
UoPClientServerRole_SERVER returns string: 'server' ;

type UopFaceProfile = 'GeneralPurpose' | 'Security' | 'SafetyBase' | 'SafetyExtended';
UopFaceProfile returns UopFaceProfile:
    UopFaceProfile_GENERAL_PURPOSE | UopFaceProfile_SECURITY | UopFaceProfile_SAFETY_BASE | UopFaceProfile_SAFETY_EXTENDED
;
UopFaceProfile_GENERAL_PURPOSE returns string: 'GeneralPurpose' ;
UopFaceProfile_SECURITY returns string: 'Security' ;
UopFaceProfile_SAFETY_BASE returns string: 'SafetyBase' ;
UopFaceProfile_SAFETY_EXTENDED returns string: 'SafetyExtended' ;

type UopDesignAssuranceLevel = 'a' | 'b' | 'c' | 'd' | 'e';
UopDesignAssuranceLevel returns UopDesignAssuranceLevel:
    UopDesignAssuranceLevel_A | UopDesignAssuranceLevel_B | UopDesignAssuranceLevel_C | UopDesignAssuranceLevel_D | UopDesignAssuranceLevel_E
;
UopDesignAssuranceLevel_A returns string: 'a' ;
UopDesignAssuranceLevel_B returns string: 'b' ;
UopDesignAssuranceLevel_C returns string: 'c' ;
UopDesignAssuranceLevel_D returns string: 'd' ;
UopDesignAssuranceLevel_E returns string: 'e' ;

type UopDesignAssuranceStandard = 'DO_178B_ED_12B' | 'DO_178C_ED_12C';
UopDesignAssuranceStandard returns UopDesignAssuranceStandard:
    UopDesignAssuranceStandard_DO_178B_ED_12B | UopDesignAssuranceStandard_DO_178C_ED_12C
;
UopDesignAssuranceStandard_DO_178B_ED_12B returns string: 'DO_178B_ED_12B' ;
UopDesignAssuranceStandard_DO_178C_ED_12C returns string: 'DO_178C_ED_12C' ;

type UopMessageExchangeType = 'InboundMessage' | 'OutboundMessage';
UopMessageExchangeType returns UopMessageExchangeType:
    UopMessageExchangeType_INBOUND_MESSAGE | UopMessageExchangeType_OUTBOUND_MESSAGE
;
UopMessageExchangeType_INBOUND_MESSAGE returns string: 'InboundMessage' ;
UopMessageExchangeType_OUTBOUND_MESSAGE returns string: 'OutboundMessage' ;

type UopPartitionType = 'POSIX' | 'ARINC653';
UopPartitionType returns UopPartitionType:
    UopPartitionType_POSIX | UopPartitionType_ARINC653
;
UopPartitionType_POSIX returns string: 'POSIX' ;
UopPartitionType_ARINC653 returns string: 'ARINC653' ;

type UopProgrammingLanguage = 'Unspecified' | 'C' | 'cpp' | 'Java' | 'Ada' | 'Go' | 'Javascript' | 'Python' | 'Rust' | 'Scala' | 'SQL' | 'Typescript';
UopProgrammingLanguage returns UopProgrammingLanguage:
    UopProgrammingLanguage_UNSPECIFIED | UopProgrammingLanguage_C | UopProgrammingLanguage_CPP | UopProgrammingLanguage_JAVA | UopProgrammingLanguage_ADA | UopProgrammingLanguage_GO | UopProgrammingLanguage_JS | UopProgrammingLanguage_PYTHON | UopProgrammingLanguage_RUST | UopProgrammingLanguage_SCALA | UopProgrammingLanguage_SQL | UopProgrammingLanguage_TS
;
UopProgrammingLanguage_UNSPECIFIED returns string: 'Unspecified' ;
UopProgrammingLanguage_C returns string: 'C' ;
UopProgrammingLanguage_CPP returns string: 'cpp' ;
UopProgrammingLanguage_JAVA returns string: 'Java' ;
UopProgrammingLanguage_ADA returns string: 'Ada' ;
UopProgrammingLanguage_GO returns string: 'Go' ;
UopProgrammingLanguage_JS returns string: 'Javascript' ;
UopProgrammingLanguage_PYTHON returns string: 'Python' ;
UopProgrammingLanguage_RUST returns string: 'Rust' ;
UopProgrammingLanguage_SCALA returns string: 'Scala' ;
UopProgrammingLanguage_SQL returns string: 'SQL' ;
UopProgrammingLanguage_TS returns string: 'Typescript' ;

type UopSynchronizationStyle = 'Blocking' | 'NonBlocking';
UopSynchronizationStyle returns UopSynchronizationStyle:
    UopSynchronizationStyle_BLOCKING | UopSynchronizationStyle_NON_BLOCKING
;
UopSynchronizationStyle_BLOCKING returns string: 'Blocking' ;
UopSynchronizationStyle_NON_BLOCKING returns string: 'NonBlocking' ;

type UopThreadType = 'Foreground' | 'Background';
UopThreadType returns UopThreadType:
    UopThreadType_FOREGROUND | UopThreadType_BACKGROUND
;
UopThreadType_FOREGROUND returns string: 'Foreground' ;
UopThreadType_BACKGROUND returns string: 'Background' ;

UopUoPModel infers UopUoPModel:
    'um' name=ID  description=STRING  '{' (um+=UopUoPModel  | element+=UopElement  )+'}'  
;

UopElement infers UopElement:
    UopSupportingComponent | UopUnitOfPortability | UopAbstractUoP | UopMessageType 
;

UopSupportingComponent infers UopSupportingComponent:
    UopComponentFramework | UopLanguageRuntime 
;

UopLanguageRuntime infers UopLanguageRuntime:
    'runtime' name=ID  ':' version=ID  description=STRING  ';'  
;

UopComponentFramework infers UopComponentFramework:
    'framework' name=ID  ':' version=ID  description=STRING  ';'  
;

UopAbstractUoP infers UopAbstractUoP:
    'aUoP' name=ID  description=STRING  '{' (connection+=UopAbstractConnection )* '};'  
;

UopAbstractConnection infers UopAbstractConnection:
    'aconn' name=ID  description=STRING  '{' ('c' conceptualView=[ConceptualView:QN ] )? ('l' logicalView=[LogicalView:QN ] )? '};'  
;

UopUnitOfPortability infers UopUnitOfPortability:
    UopPortableComponent | UopPlatformSpecificComponent 
;

UopPortableComponent infers UopPortableComponent:
    'pc' name=ID  description=STRING  ('->' realizes=[UopAbstractUoP:QN ] )? '{' 'lang:' transportAPILanguage=UopProgrammingLanguage  ('part:' partitionType=UopPartitionType  )? ('prof:' faceProfile=UopFaceProfile  )? ('DAL:' designAssuranceLevel=UopDesignAssuranceLevel  )? ('DAS:' designAssuranceStandard=UopDesignAssuranceStandard  )? ('RAM:' memoryRequirements=UopRAMMemoryRequirements  )? ('thread:' '[' thread+=UopThread + ']' )? ('support:' '[' supportingComponent+=[UopSupportingComponent:QN ]+ ']' )? 'conn:' '[' connection+=UopConnection + ']' ('lcm:' '[' lcmPort+=UopLifeCycleManagementPort  lcmPort+=UopLifeCycleManagementPort ? ']' )? ('implementedBy:' implementedBy=[IntegrationIntegrationContext:QN ] )? '};'  
;

UopPlatformSpecificComponent infers UopPlatformSpecificComponent:
    'psc' name=ID  description=STRING  ('->' realizes=[UopAbstractUoP:QN ] )? '{' 'lang:' transportAPILanguage=UopProgrammingLanguage  ('part:' partitionType=UopPartitionType  )? ('prof:' faceProfile=UopFaceProfile  )? ('DAL:' designAssuranceLevel=UopDesignAssuranceLevel  )? ('DAS:' designAssuranceStandard=UopDesignAssuranceStandard  )? ('RAM:' memoryRequirements=UopRAMMemoryRequirements  )? ('thread:' '[' thread+=UopThread + ']' )? ('support:' '[' supportingComponent+=[UopSupportingComponent:QN ]+ ']' )? 'conn:' '[' connection+=UopConnection + ']' ('lcm:' '[' lcmPort+=UopLifeCycleManagementPort  lcmPort+=UopLifeCycleManagementPort ? ']' )? ('implementedBy:' implementedBy=[IntegrationIntegrationContext:QN ] )? '};'  
;

UopThread infers UopThread:
    '(' 'per:' period=FLOAT  'timeCap:' timeCapacity=FLOAT  'prio:' relativePriority=INT  'core:' relativeCoreAffinity=INT  'thread:' threadType=UopThreadType  ')'  
;

UopRAMMemoryRequirements infers UopRAMMemoryRequirements:
    { infer UopRAMMemoryRequirements} '(' ('heap:' '[' heapStackMin=INT ? ':' heapStackTypical=INT ? ':' heapStackMax=INT ? ']' )? ('text:' textMax=INT  )? ('roData:' roDataMax=INT  )? ('data:' dataMax=INT  )? ('bss:' bssMax=INT  )? ')'  
;

UopConnection infers UopConnection:
    UopPubSubConnection | UopClientServerConnection 
;

UopClientServerConnection infers UopClientServerConnection:
    'csconn' name=ID  description=STRING  ('->' realizes=[UopAbstractConnection:QN ] )? '{' 'msg:' '[' requestType=[UopMessageType:QN ] '/' responseType=[UopMessageType:QN ] ']' (synchronizationStyle=UopSynchronizationStyle )? 'role:' role=UoPClientServerRole  ('period:' period=FLOAT  )? ('mapsTo:' mapsTo=[IntegrationTransportNode:QN ] )? '}'  
;

UopPubSubConnection infers UopPubSubConnection:
    UopQueuingConnection | UopSingleInstanceMessageConnection 
;

UopQueuingConnection infers UopQueuingConnection:
    'qconn' name=ID  description=STRING  ('->' realizes=[UopAbstractConnection:QN ] )? '{' 'msg:' messageExchangeType=UopMessageExchangeType  messageType=[UopMessageType:QN ] (synchronizationStyle=UopSynchronizationStyle )? ('depth:' depth=INT  )? ('period:' period=FLOAT  )? ('mapsTo:' mapsTo=[IntegrationTransportNode:QN ] )? '}'  
;

UopSingleInstanceMessageConnection infers UopSingleInstanceMessageConnection:
    'simconn' name=ID  description=STRING  ('->' realizes=[UopAbstractConnection:QN ] )? '{' 'msg:' messageExchangeType=UopMessageExchangeType  messageType=[UopMessageType:QN ] (synchronizationStyle=UopSynchronizationStyle )? ('period:' period=FLOAT  )? ('mapsTo:' mapsTo=[IntegrationTransportNode:QN ] )? '}'  
;

UopLifeCycleManagementPort infers UopLifeCycleManagementPort:
    '(' messageExchangeType=UopMessageExchangeType  lcmMessageType=[UopMessageType:QN ] ')'  
;

UopMessageType infers UopMessageType:
    UopTemplate | UopCompositeTemplate 
;

UopCompositeTemplate infers UopCompositeTemplate:
    'ctempl' name=ID  description=STRING  ('->' realizes=[LogicalCompositeQuery:QN ] )? '{' isUnion?='isUnion'  composition+=UopTemplateComposition  (composition+=UopTemplateComposition )+ '};'  
;

UopTemplateComposition infers UopTemplateComposition:
    ^type=[UopMessageType:QN ] rolename=STRING  ('->' realizes=[LogicalQueryComposition:QN ] )?  
;

UopTemplate infers UopTemplate:
    'templ' name=ID  description=STRING  '{' 'spec:' specification=STRING  'bound:' boundQuery=[PlatformQuery:QN ] ('effective:' effectiveQuery=[PlatformQuery:QN ] )? '};'  
;

IntegrationIntegrationModel infers IntegrationIntegrationModel:
    'im' name=ID  description=STRING  '{' (im+=IntegrationIntegrationModel  | element+=IntegrationElement  )*'}'  
;

IntegrationElement infers IntegrationElement:
    IntegrationUoPInstance | IntegrationTransportChannel | IntegrationIntegrationContext 
;

IntegrationIntegrationContext infers IntegrationIntegrationContext:
    'ic' name=ID  description=STRING  '{' ('xport:' '[' node+=IntegrationTransportNode + ']' )? ('conn:' '[' connection+=IntegrationTSNodeConnection + ']' )? '}'  
;

IntegrationTSNodeConnection infers IntegrationTSNodeConnection:
    '(' 'U2U'? source=[IntegrationUoPOutputEndPoint:QN ] '->' destination=[IntegrationUoPInputEndPoint:QN ] ')'  | '(' 'U2T' source=[IntegrationUoPOutputEndPoint:QN ] '->' destination=[IntegrationTSNodeInputPort:QN ] ')'  | '(' 'T2U' source=[IntegrationTSNodeOutputPort:QN ] '->' destination=[IntegrationUoPInputEndPoint:QN ] ')'  | '(' 'T2T' source=[IntegrationTSNodeOutputPort:QN ] '->' destination=[IntegrationTSNodeInputPort:QN ] ')'  
;

IntegrationTSNodePortBase infers IntegrationTSNodePortBase:
    IntegrationUoPInputEndPoint | IntegrationUoPOutputEndPoint | IntegrationTSNodeInputPort | IntegrationTSNodeOutputPort 
;

IntegrationUoPInstance infers IntegrationUoPInstance:
    'uinst' name=ID  description=STRING  '->' realizes=[UopUnitOfPortability:QN ] '{' ('uri:' configurationURI=STRING  )? ('input:' '[' input+=IntegrationUoPInputEndPoint + ']' )? ('output:' '[' output+=IntegrationUoPOutputEndPoint + ']' )? '};'  
;

IntegrationUoPInputEndPoint infers IntegrationUoPInputEndPoint:
    connection=[UopConnection:QN ] 
;

IntegrationUoPOutputEndPoint infers IntegrationUoPOutputEndPoint:
    connection=[UopConnection:QN ] 
;

IntegrationTransportNode infers IntegrationTransportNode:
    IntegrationViewTransporter | IntegrationViewAggregation | IntegrationViewTransformation | IntegrationViewFilter | IntegrationViewSink | IntegrationViewSource 
;

IntegrationTSNodeInputPort infers IntegrationTSNodeInputPort:
    view=[UopMessageType:QN ] 
;

IntegrationTSNodeOutputPort infers IntegrationTSNodeOutputPort:
    view=[UopMessageType:QN ] 
;

IntegrationViewAggregation infers IntegrationViewAggregation:
    'agg' name=ID  description=STRING  '{' 'in:' '[' inPort+=IntegrationTSNodeInputPort + ']' 'out:' outPort=IntegrationTSNodeOutputPort  '};'  
;

IntegrationViewFilter infers IntegrationViewFilter:
    'filter' name=ID  description=STRING  '{' 'in:' '[' inPort+=IntegrationTSNodeInputPort + ']' ('out:' outPort=IntegrationTSNodeOutputPort  )? '};'  
;

IntegrationViewSource infers IntegrationViewSource:
    'src' name=ID  description=STRING  '{' ('in:' '[' inPort+=IntegrationTSNodeInputPort + ']' )? 'out:' outPort=IntegrationTSNodeOutputPort  '};'  
;

IntegrationViewSink infers IntegrationViewSink:
    'sink' name=ID  description=STRING  '{' 'in:' '[' inPort+=IntegrationTSNodeInputPort + ']' ('out:' outPort=IntegrationTSNodeOutputPort  )? '};'  
;

IntegrationViewTransformation infers IntegrationViewTransformation:
    'xform' name=ID  description=STRING  '{' 'in:' '[' inPort+=IntegrationTSNodeInputPort + ']' 'out:' outPort=IntegrationTSNodeOutputPort  '};'  
;

IntegrationViewTransporter infers IntegrationViewTransporter:
    'xport' name=ID  description=STRING  '{' 'in:' '[' inPort+=IntegrationTSNodeInputPort + ']' 'out:' outPort=IntegrationTSNodeOutputPort  'chan:' channel=[IntegrationTransportChannel:QN ] '};'  
;

IntegrationTransportChannel infers IntegrationTransportChannel:
    'itc' name=ID  description=STRING  ';'  
;

