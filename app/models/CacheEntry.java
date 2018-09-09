package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by pratyush.k on 09/09/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheEntry {
    private String key;
    private Object value;
    private int ttl;
}
