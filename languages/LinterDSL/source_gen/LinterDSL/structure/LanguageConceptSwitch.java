package LinterDSL.structure;

/*Generated by MPS */

import jetbrains.mps.lang.smodel.LanguageConceptIndex;
import jetbrains.mps.lang.smodel.LanguageConceptIndexBuilder;
import jetbrains.mps.smodel.adapter.ids.SConceptId;
import org.jetbrains.mps.openapi.language.SAbstractConcept;

public final class LanguageConceptSwitch {
  private final LanguageConceptIndex myIndex;
  public static final int AllowedChildrenCheck = 0;
  public static final int AttributeSelector = 1;
  public static final int Check = 2;
  public static final int ClassSelector = 3;
  public static final int CustomSelector = 4;
  public static final int DirectParentCheck = 5;
  public static final int GroupSelector = 6;
  public static final int InvalidElementCheck = 7;
  public static final int Linter = 8;
  public static final int MissingElementCheck = 9;
  public static final int MisuseCheck = 10;
  public static final int PredecessorsCheck = 11;
  public static final int RequiredChildCheck = 12;
  public static final int Selector = 13;
  public static final int StandardSelector = 14;
  public static final int TagSelector = 15;

  public LanguageConceptSwitch() {
    LanguageConceptIndexBuilder builder = new LanguageConceptIndexBuilder(0xc400f4156edc4c5fL, 0xa0ceccbb04f551e6L);
    builder.put(0x472d73cdfe35f5d5L, AllowedChildrenCheck);
    builder.put(0x704031341929f121L, AttributeSelector);
    builder.put(0x74695853078e2ae8L, Check);
    builder.put(0x704031341929f113L, ClassSelector);
    builder.put(0x704031341929f122L, CustomSelector);
    builder.put(0x709bab50272a6dcaL, DirectParentCheck);
    builder.put(0x704031341929f116L, GroupSelector);
    builder.put(0x3d485cfa289b3f77L, InvalidElementCheck);
    builder.put(0x74695853078e2ad1L, Linter);
    builder.put(0x472d73cdfe350f81L, MissingElementCheck);
    builder.put(0x472d73cdfe35f711L, MisuseCheck);
    builder.put(0x686f417f617be32cL, PredecessorsCheck);
    builder.put(0x7d9d4177b0175848L, RequiredChildCheck);
    builder.put(0x1419e78e6791ffedL, Selector);
    builder.put(0x704031341929f11eL, StandardSelector);
    builder.put(0x704031341929f11bL, TagSelector);
    myIndex = builder.seal();
  }

  /*package*/ int index(SConceptId cid) {
    return myIndex.index(cid);
  }

  public int index(SAbstractConcept concept) {
    return myIndex.index(concept);
  }
}
