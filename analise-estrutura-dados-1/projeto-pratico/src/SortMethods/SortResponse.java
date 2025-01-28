package SortMethods;

import utils.TimeProvider;

import java.time.Instant;

public class SortResponse {
	private int[] finalVector;
	private double startTime = 0;
	private double endTime = 0;
	private TimeProvider timeProvider = new TimeProvider();

	public void startTimer() {
		Instant currentInstant = this.timeProvider.getUniqueInstant();
		double seconds = currentInstant.getEpochSecond() * 1E9;
		int nano = currentInstant.getNano();
		this.startTime = seconds + nano;
	}

	public void endTimer() {
		Instant currentInstant = this.timeProvider.getUniqueInstant();
		double seconds = currentInstant.getEpochSecond() * 1E9;
		int nano = currentInstant.getNano();
		this.endTime = seconds + nano;
	}

	public int[] getFinalVector() {
		return finalVector;
	}

	public void setFinalVector(int[] vector) {
		finalVector = vector.clone();
	}

	public void printFinalVector() {
		for (int item : finalVector) {
			System.out.println(item);
		}
	}

	// transforma os nanosegundos em microsegundos e retorna a duração
	public double getSortDuration() {
		return (endTime - startTime) / 1e3;
	}
}
