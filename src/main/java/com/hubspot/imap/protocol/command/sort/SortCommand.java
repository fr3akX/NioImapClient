package com.hubspot.imap.protocol.command.sort;

import com.hubspot.imap.protocol.command.BaseImapCommand;
import com.hubspot.imap.protocol.command.ImapCommandType;
import com.hubspot.imap.protocol.command.search.keys.SearchKey;
import com.hubspot.imap.protocol.command.sort.keys.SortKey;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortCommand extends BaseImapCommand {
  private List<SearchKey> keys;

  public SortCommand(List<SortKey> sort, SearchKey... keys) {
    super(ImapCommandType.SORT, keysAsString(sort, keys));
    this.keys = Arrays.asList(keys);
  }

  private static String keysAsString(List<SortKey> sort, SearchKey[] keys) {
    //RETURN (PARTIAL 1:500)
    return  "(" + SPACE_JOINER.join(sort) + ") UTF-8 " + SPACE_JOINER.join(Arrays.asList(keys).stream()
                               .map(SearchKey::keyString)
                               .collect(Collectors.toList()));
  }

  public List<SearchKey> getKeys() {
    return keys;
  }
}
