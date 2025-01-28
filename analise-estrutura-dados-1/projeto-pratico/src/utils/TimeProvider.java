package utils;

import java.time.Instant;

public class TimeProvider {

	public Instant last = Instant.now().minusSeconds(1);

	public Instant getUniqueInstant() {
		Instant result = Instant.now();
		if (!result.isAfter(last)) {
			result = last.plusNanos(1);
		}
		last = result;
		return result;
	}
}
