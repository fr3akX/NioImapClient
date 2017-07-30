package com.hubspot.imap.protocol.response.tagged;

import com.hubspot.imap.protocol.exceptions.ResponseParseException;
import com.hubspot.imap.protocol.response.untagged.UntaggedSearchResponse;
import com.hubspot.imap.protocol.response.untagged.UntaggedSortResponse;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface SortResponse extends TaggedResponse {

  List<Long> getMessageIds();

  class Builder extends TaggedResponse.Builder implements SortResponse {
    private List<Long> messageIds;

    public SortResponse fromResponse(TaggedResponse input) throws ResponseParseException {
      messageIds = input.getUntagged().stream()
          .filter(o -> o instanceof UntaggedSortResponse)
          .map(o -> ((UntaggedSortResponse) o))
          .map(UntaggedSortResponse::getIds)
          .flatMap(Collection::stream)
          .collect(Collectors.toList());

      setCode(input.getCode());
      setMessage(input.getMessage());
      setTag(input.getTag());

      return this;
    }

    public List<Long> getMessageIds() {
      return messageIds;
    }
  }
}
