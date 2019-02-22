package LinterDSL.textGen;

/*Generated by MPS */

import jetbrains.mps.text.rt.TextGenDescriptorBase;
import jetbrains.mps.text.rt.TextGenContext;
import jetbrains.mps.text.impl.TextGenSupport;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class Linter_TextGen extends TextGenDescriptorBase {
  @Override
  public void generateText(final TextGenContext ctx) {
    final TextGenSupport tgs = new TextGenSupport(ctx);
    tgs.append("function misuseCheck(name, id, description, applyTo, required, prohibited) {");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (!disabledChecks.includes(id)) {");
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var missingRequired = [];");
    tgs.newLine();
    tgs.indent();
    tgs.append("var withProhibited = [];");
    tgs.newLine();
    tgs.indent();
    tgs.append("applyTo.forEach(function(selector) {");
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("missingRequired.push($(selector).filter(':not(' + required.join(',') + ')'));");
    tgs.newLine();
    tgs.indent();
    tgs.append("withProhibited.push($(selector).filter(prohibited.join(',')));");
    ctx.getBuffer().area().decreaseIndent();

    tgs.indent();
    tgs.append("});");
    tgs.newLine();

    tgs.indent();
    tgs.append("if (missingRequired.length || withProhibited.length) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var message = 'name + ' id = ' + id + ':';");
    tgs.newLine();
    tgs.indent();
    tgs.append("message += 'elements which satisfy [' + applyTo.join(' or ') + ']';");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (required.length) message += 'must also satisfy [' + required.join(' or ') + ']';");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (required.length && prohibited.length) message += ' and ';");
    tgs.newLine();
    tgs.indent();
    tgs.append("if (prohibited.length) message += 'can not match + [' prohibited.join(' or ') +  ']';");
    tgs.newLine();
    tgs.indent();
    tgs.append("message += '.';");
    tgs.newLine();
    tgs.indent();
    tgs.append("console.warn(message, missingRequired.concat(withProhibited));");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();

    tgs.indent();
    tgs.append("}");
    tgs.newLine();

    ctx.getBuffer().area().decreaseIndent();

    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();

    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.append("function childrenTypeCheck(name, id, description, applyTo, allow, prohibit, required, violationMessage) {");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (!disable.includes(id)) {");
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();

    tgs.append("var inappropriateChildren = [];");
    tgs.newLine();
    tgs.indent();
    tgs.append("var elementsMissingChildren = false;");
    tgs.newLine();
    tgs.indent();
    tgs.append("applyTo.forEach(function(selector) {");
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("inappropriateChildren.push($(selector + ' ~ :not(' + allowed.join(',') + ')'));");
    tgs.newLine();
    tgs.indent();
    tgs.append("required.forEach(function(required) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("$(selector).forEach(funciton(element) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (!element.has(requiredChild).lenght) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("elementsMissingChildren.push(element);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();

    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();

    tgs.indent();
    tgs.append("if ($(elementsMissingChildren.length || $(inappropriateChildren).length) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("console.warn(violationMessage);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.append("function missingTagCheck(name, id, description, applyTo, unique, violationMessage) {");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var missingTags = [];");
    tgs.newLine();
    tgs.indent();
    tgs.append("var duplicatedTags = [];");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("applyTo.forEach(function(selector) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (!$(selector).length) {");
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("missingTags.push(selector);");
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();

    tgs.indent();
    tgs.append("if ($(selector).length) > 1 && unique) {");
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("duplicatedTags.concat($(selector));");
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();

    tgs.newLine();
    for (SNode item : SLinkOperations.getChildren(ctx.getPrimaryInput(), MetaAdapterFactory.getContainmentLink(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L, 0x74695853078e2ad1L, 0x74695853078e2ae6L, "checks"))) {
      tgs.appendNode(item);
    }

    tgs.append("function parentTypeCheck(name, id, applyTo, allowedDirectParents) {");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var elementsWithInappropriateParents = [];");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("applyTo.forEach(function(selector) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("$(selector).forEach(function (element) {)");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var hasInappropriateParent = true;");
    tgs.newLine();
    tgs.indent();
    tgs.append("allowedDirectParents.forEach(function (allowedParentSelector) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (element.parentElement.matches(allowedParentSelector)) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("hasInappropriateParents = false;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (hasInappropriateParents) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("elementsWithInappropriateParents.push(element);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("if (elementsWithInappropriateParents.length) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var message = name + ' {id: ' + id + '): elements which satisfy ' + applyTo.join(' or ') + ");
    tgs.append("'can anly be direct children of the following: ' + allowedDirectParents.join(, ) + '.'");
    tgs.newLine();
    tgs.append("console.warn(message, elementsWithInappropriateParents);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();

    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    tgs.append("function parentTypeCheck(name, id, applyTo, requiredAttributes) {");
    tgs.newLine();
    tgs.newLine();

    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var elementsMissingAttributes = [];");
    tgs.newLine();
    tgs.newLine();

    tgs.indent();
    tgs.append("applyTo.forEach(function(selector) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("$(selector).forEach(function (element) {)");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("var isMissingAttribute = false;");
    tgs.newLine();
    tgs.indent();
    tgs.append("requiredAttributes.forEach(function (attribute) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (!element.matches(attribute)) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("isMissingAttribute = true;");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("if (isMissingAttribute) {");
    tgs.newLine();
    ctx.getBuffer().area().increaseIndent();
    tgs.indent();
    tgs.append("elementsMissingAttributes.push(element);");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("});");
    tgs.newLine();
    ctx.getBuffer().area().decreaseIndent();
    tgs.indent();
    tgs.append("}");
    tgs.newLine();
    tgs.newLine();

    for (SNode item : SLinkOperations.getChildren(ctx.getPrimaryInput(), MetaAdapterFactory.getContainmentLink(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L, 0x74695853078e2ad1L, 0x74695853078e2ae6L, "checks"))) {
      tgs.appendNode(item);
    }


  }
}
