package com.hubspot.imap.protocol.response.untagged;

import java.util.List;

public class UntaggedSortResponse implements UntaggedResponse {

  private final List<Long> ids;

  public UntaggedSortResponse(List<Long> ids) {
    this.ids = ids;
  }

  @Override
  public UntaggedResponseType getType() {
    return UntaggedResponseType.SORT;
  }

  @Override
  public String getMessage() {
    return null;
  }

  public List<Long> getIds() {
    return ids;
  }
}
