/*
 * generated by Xtext 2.28.0
 */
package com.epistimis.face.formatting2

import com.epistimis.face.face.ArchitectureModel
import com.epistimis.face.face.IntegrationIntegrationContext
import com.epistimis.face.face.IntegrationIntegrationModel
import com.epistimis.face.face.IntegrationTransportNode
import com.epistimis.face.face.IntegrationUoPInstance
import com.epistimis.face.face.UopClientServerConnection
import com.epistimis.face.face.UopCompositeTemplate
import com.epistimis.face.face.UopConnection
import com.epistimis.face.face.UopQueuingConnection
import com.epistimis.face.face.UopRAMMemoryRequirements
import com.epistimis.face.face.UopSingleInstanceMessageConnection
import com.epistimis.face.face.UopTemplate
import com.epistimis.face.face.UopThread
import com.epistimis.face.face.UopUnitOfPortability
import com.epistimis.face.face.UopUoPModel
//import com.epistimis.face.services.FaceGrammarAccess
import com.epistimis.uddl.formatting2.UddlFormatter
//import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.IFormattableDocument

import static com.epistimis.face.face.FacePackage.Literals.*

class FaceFormatter extends UddlFormatter {
	
//	@Inject extension FaceGrammarAccess

	/**
	 * Several standard methods needed for formatting
	 * 1) All objects will have
	 * 		A) '{' and '};' on a newline.
	 * 		B) All content inside the '{' and '}' will be indented one tab
	 *
	 * NOTES: Because we don't know the structure of the object, we don't know how to format its
	 * content. So we format the open and close separately
	 *
	 * 2) '{' and '}' for scoping means
	 * 		A) all content indented one tab further
	 * 		B) '{' on newline after name/description of scope
	 *
	 * 3) '[' and ']' for lists means
	 * 		A) all list content have 1 space between
	 * 		B) '[', ']' and content all on the same line
	 *
	 *
	 */

	/** General functions - See UddlFormatter which this inherits*/


	/** Model specific functions */

	def dispatch void format(ArchitectureModel architectureModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		architectureModel.formatContainer(document)
		for (dataModel : architectureModel.dm) {
			dataModel.format
		}
		for (uopUoPModel : architectureModel.um) {
			uopUoPModel.format
		}
		for (integrationIntegrationModel : architectureModel.im) {
			integrationIntegrationModel.format
		}
	}

	def dispatch void format(UopUoPModel uopUoPModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		uopUoPModel.formatContainer(document)
		for (_uopUoPModel : uopUoPModel.um) {
			_uopUoPModel.format
		}
		for (uopElement : uopUoPModel.element) {
			uopElement.format
		}
	}
	
	// TODO: implement for UopAbstractUoP, UopUnitOfPortability, UopClientServerConnection, UopCompositeTemplate, IntegrationIntegrationModel, IntegrationIntegrationContext, IntegrationUoPInstance, IntegrationViewAggregation, IntegrationViewFilter, IntegrationViewSink, IntegrationViewSource, IntegrationViewTransformation, IntegrationViewTransporter


	/** UoP */
	def dispatch void format(UopUnitOfPortability obj, extension IFormattableDocument document) {
//		obj.prepend[newLine]
		formatObj(obj,document);
		formatAttribute(obj.regionFor.keyword('lang:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__TRANSPORT_API_LANGUAGE),document);
		formatAttribute(obj.regionFor.keyword('part:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__PARTITION_TYPE),document);
		formatAttribute(obj.regionFor.keyword('prof:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__FACE_PROFILE),document);
		formatAttribute(obj.regionFor.keyword('DAL:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__DESIGN_ASSURANCE_LEVEL),document);
		formatAttribute(obj.regionFor.keyword('DAS:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__DESIGN_ASSURANCE_STANDARD),document);
		formatAttribute(obj.regionFor.keyword('support:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__SUPPORTING_COMPONENT),document);
		formatAttribute(obj.regionFor.keyword('conn:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__CONNECTION),document);
		formatAttribute(obj.regionFor.keyword('lcm:'),obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__LCM_PORT),document);
//		formatAttributeElement(obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__MEMORY_REQUIREMENTS ),document);
//		formatAttributeElement(obj.regionFor.feature(UOP_UNIT_OF_PORTABILITY__THREAD ),document);
		for (EObject contained: obj.eContents) {
			// This should handle RAM, Thread
			contained.format
		}
		for (EObject elem: obj.connection) {
			obj.surround[oneSpace]
		}
		
	}

	def dispatch void format(UopThread obj, extension IFormattableDocument document) {
		formatAttribute(obj.regionFor.keyword('per:'),obj.regionFor.feature(UOP_THREAD__PERIOD),document);
		formatAttribute(obj.regionFor.keyword('timeCap:'),obj.regionFor.feature(UOP_THREAD__TIME_CAPACITY),document);
		formatAttribute(obj.regionFor.keyword('prio:'),obj.regionFor.feature(UOP_THREAD__RELATIVE_PRIORITY),document);
		formatAttribute(obj.regionFor.keyword('core:'),obj.regionFor.feature(UOP_THREAD__RELATIVE_CORE_AFFINITY),document);
		formatAttribute(obj.regionFor.keyword('thread:'),obj.regionFor.feature(UOP_THREAD__THREAD_TYPE),document);
	}

	def dispatch void format(UopRAMMemoryRequirements obj, extension IFormattableDocument document) {
		// HEAP isn't formatted the same way
		formatAttributeElement(obj.regionFor.feature(UOP_RAM_MEMORY_REQUIREMENTS__HEAP_STACK_MIN ),document);
		formatAttributeElement(obj.regionFor.feature(UOP_RAM_MEMORY_REQUIREMENTS__HEAP_STACK_TYPICAL ),document);
		formatAttributeElement(obj.regionFor.feature(UOP_RAM_MEMORY_REQUIREMENTS__HEAP_STACK_MAX ),document);

		formatAttribute(obj.regionFor.keyword('text:'),obj.regionFor.feature(UOP_RAM_MEMORY_REQUIREMENTS__TEXT_MAX),document);
		formatAttribute(obj.regionFor.keyword('roData:'),obj.regionFor.feature(UOP_RAM_MEMORY_REQUIREMENTS__RO_DATA_MAX),document);
		formatAttribute(obj.regionFor.keyword('data:'),obj.regionFor.feature(UOP_RAM_MEMORY_REQUIREMENTS__DATA_MAX),document);
		formatAttribute(obj.regionFor.keyword('bss:'),obj.regionFor.feature(UOP_RAM_MEMORY_REQUIREMENTS__BSS_MAX),document);
	}

	def void formatConnection(UopConnection obj, extension IFormattableDocument document) {
		obj.formatObj(document)
		formatAttributeElement(obj.regionFor.feature(UOP_CONNECTION__PERIOD ),document);
		formatAttributeElement(obj.regionFor.feature(UOP_CONNECTION__SYNCHRONIZATION_STYLE ),document);		
	}
	def dispatch void format(UopClientServerConnection obj, extension IFormattableDocument document) {
		obj.formatConnection(document)
		formatAttributeElement(obj.regionFor.feature(UOP_CLIENT_SERVER_CONNECTION__ROLE ),document);		
	}
	def dispatch void format(UopQueuingConnection obj, extension IFormattableDocument document) {
		obj.formatConnection(document)
		formatAttributeElement(obj.regionFor.feature(UOP_QUEUING_CONNECTION__DEPTH ),document);		
	}
	def dispatch void format(UopSingleInstanceMessageConnection obj, extension IFormattableDocument document) {
		obj.formatConnection(document)
	}

	def dispatch void format(UopCompositeTemplate obj, extension IFormattableDocument document) {
		obj.prepend[newLine]
		formatObj(obj,document);
		for (EObject contained: obj.eContents) {
			contained.format
		}
	}

	def dispatch void format(UopTemplate obj, extension IFormattableDocument document) {
		formatObj(obj,document);		
		formatAttributeElement(obj.regionFor.feature(UOP_TEMPLATE__BOUND_QUERY ),document);
		formatAttributeElement(obj.regionFor.feature(UOP_TEMPLATE__EFFECTIVE_QUERY ),document);
		formatAttributeElement(obj.regionFor.feature(UOP_TEMPLATE__SPECIFICATION),document);
	}

	/** Integration  */
	def dispatch void format(IntegrationIntegrationModel obj, extension IFormattableDocument document) {
		obj.formatContainer(document)
		for (_im : obj.im) {
			_im.format
		}
		for (uopElement : obj.element) {
			uopElement.format
		}
	}
	

	def dispatch void format(IntegrationIntegrationContext obj, extension IFormattableDocument document) {
		obj.formatObj(document);
		for (c : obj.connection) {
			c.format
			c.append[setNewLines(1, 1, 2)]
		}
		for (c : obj.node) {
			c.format
			c.append[setNewLines(1, 1, 2)]
		}
	}

	def dispatch void format(IntegrationUoPInstance obj, extension IFormattableDocument document) {
		obj.formatObj(document);
		for (c : obj.input) {
			c.format
			c.append[setNewLines(1, 1, 2)]
		}
		for (c : obj.output) {
			c.format
			c.append[setNewLines(1, 1, 2)]
		}
	}

	def dispatch void format(IntegrationTransportNode obj, extension IFormattableDocument document) {
		obj.formatObj(document);
		for (c : obj.inPort) {
			c.format
			c.append[setNewLines(1, 1, 2)]
		}
		obj.outPort.format
	}


}
