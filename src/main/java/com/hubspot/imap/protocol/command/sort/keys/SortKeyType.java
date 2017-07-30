package com.hubspot.imap.protocol.command.sort.keys;

public interface SortKeyType {
  String keyString();

  enum StandardSortKeyTypes implements SortKeyType {
    ARRIVAL,
    CC,
    FROM,
    REVERSE,
    SIZE,
    SUBJECT,
    TO,
    DATE;

    @Override
    public String keyString() {
      return name();
    }
  }
}
