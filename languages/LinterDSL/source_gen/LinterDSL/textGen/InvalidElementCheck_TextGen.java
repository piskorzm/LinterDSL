package LinterDSL.textGen;

/*Generated by MPS */

import jetbrains.mps.text.rt.TextGenDescriptorBase;
import jetbrains.mps.text.rt.TextGenContext;
import jetbrains.mps.text.impl.TextGenSupport;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class InvalidElementCheck_TextGen extends TextGenDescriptorBase {
  @Override
  public void generateText(final TextGenContext ctx) {
    final TextGenSupport tgs = new TextGenSupport(ctx);
    tgs.indent();
    tgs.append("invalidElementCheck(");
    tgs.append(Integer.toString(SPropertyOperations.getInteger(ctx.getPrimaryInput(), MetaAdapterFactory.getProperty(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L, 0x74695853078e2ae8L, 0x74695853078e2af2L, "id"))));
    tgs.append(", '");
    tgs.append(SPropertyOperations.getString(ctx.getPrimaryInput(), MetaAdapterFactory.getProperty(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L, 0x74695853078e2ae8L, 0x7f24bdd32ec692c5L, "customMessage")));
    tgs.append("', '");
    tgs.append(SPropertyOperations.getString(ctx.getPrimaryInput(), MetaAdapterFactory.getProperty(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L, 0x74695853078e2ae8L, 0x1419e78e6791678eL, "type")));
    tgs.append("', ");
    tgs.append("['");
    Linter_functions.toStringList(SLinkOperations.getChildren(ctx.getPrimaryInput(), MetaAdapterFactory.getContainmentLink(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L, 0x74695853078e2ae8L, 0x1419e78e679167d2L, "applyTo")), ctx);
    tgs.append("']);");
    tgs.newLine();
  }
}
