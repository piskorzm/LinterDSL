package LinterDSL.textGen;

/*Generated by MPS */

import jetbrains.mps.text.rt.TextGenAspectBase;
import LinterDSL.structure.LanguageConceptSwitch;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.text.rt.TextGenDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.text.rt.TextGenModelOutline;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class TextGenAspectDescriptor extends TextGenAspectBase {
  private final LanguageConceptSwitch myIndex = new LanguageConceptSwitch();

  public TextGenAspectDescriptor() {
  }

  @Nullable
  @Override
  public TextGenDescriptor getDescriptor(@NotNull SAbstractConcept concept) {
    switch (myIndex.index(concept)) {
      case LanguageConceptSwitch.AllowedChildrenCheck:
        return new AllowedChildrenCheck_TextGen();
      case LanguageConceptSwitch.AttributeSelector:
        return new AttributeSelector_TextGen();
      case LanguageConceptSwitch.ClassSelector:
        return new ClassSelector_TextGen();
      case LanguageConceptSwitch.CustomSelector:
        return new CustomSelector_TextGen();
      case LanguageConceptSwitch.DirectParentCheck:
        return new DirectParentCheck_TextGen();
      case LanguageConceptSwitch.GroupSelector:
        return new GroupSelector_TextGen();
      case LanguageConceptSwitch.InvalidElementCheck:
        return new InvalidElementCheck_TextGen();
      case LanguageConceptSwitch.Linter:
        return new Linter_TextGen();
      case LanguageConceptSwitch.MissingElementCheck:
        return new MissingElementCheck_TextGen();
      case LanguageConceptSwitch.MisuseCheck:
        return new MisuseCheck_TextGen();
      case LanguageConceptSwitch.PredecessorsCheck:
        return new PredecessorsCheck_TextGen();
      case LanguageConceptSwitch.RequiredChildCheck:
        return new RequiredChildCheck_TextGen();
      case LanguageConceptSwitch.TagSelector:
        return new TagSelector_TextGen();
    }
    return null;
  }

  @Override
  public void breakdownToUnits(@NotNull TextGenModelOutline outline) {
    for (SNode root : outline.getModel().getRootNodes()) {
      if (root.getConcept().equals(MetaAdapterFactory.getConcept(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L, 0x74695853078e2ad1L, "LinterDSL.structure.Linter"))) {
        String fname = getFileName_Linter(root);
        String ext = getFileExtension_Linter(root);
        outline.registerTextUnit((ext == null ? fname : (fname + '.' + ext)), root);
        continue;
      }
    }
  }
  private static String getFileName_Linter(SNode node) {
    return node.getName();
  }
  private static String getFileExtension_Linter(SNode node) {
    return "js";
  }
}
