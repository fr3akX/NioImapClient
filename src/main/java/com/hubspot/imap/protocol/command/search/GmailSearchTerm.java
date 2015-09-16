package com.hubspot.imap.protocol.command.search;

public enum GmailSearchTerm implements SearchTermType {
  RAW("X-GM-RAW"),
  MSGID("X-GM-MSGID"),
  THRID("X-GM-THRID");

  public final String string;

  GmailSearchTerm(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
