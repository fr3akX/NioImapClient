package com.hubspot.imap.protocol.command.sort.keys;

import com.hubspot.imap.protocol.command.atoms.BaseImapAtom;

public class SortKey extends BaseImapAtom {
  private final SortKeyType typ;

  public SortKey(SortKeyType typ) {
    this.typ = typ;
  }

  public String keyString() {
    return typ.keyString();
  }
  public SortKeyType getKeyType() {
    return typ;
  }

  @Override
  public String getPrefix() {
    return typ.keyString();
  }
}
