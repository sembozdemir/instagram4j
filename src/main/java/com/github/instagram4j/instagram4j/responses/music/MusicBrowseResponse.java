package com.github.instagram4j.instagram4j.responses.music;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import com.github.instagram4j.instagram4j.models.music.MusicPlaylist;
import com.github.instagram4j.instagram4j.responses.IGResponse;
import com.github.instagram4j.instagram4j.utils.IGUtils;

import lombok.Data;

@Data
public class MusicBrowseResponse extends IGResponse {
    @JsonDeserialize(converter = BeanToIGMusicPlaylistConverter.class)
    private List<MusicPlaylist> items;
    
    private static class BeanToIGMusicPlaylistConverter extends StdConverter<List<Map<String, Object>>, List<MusicPlaylist>> {
        @Override
        public List<MusicPlaylist> convert(List<Map<String, Object>> value) {
            return value.stream()
                    .filter(m -> m.containsKey("playlist"))
                    .map(m -> IGUtils.convertToView(m.get("playlist"), MusicPlaylist.class))
                    .collect(Collectors.toList());
        }
    }
}
