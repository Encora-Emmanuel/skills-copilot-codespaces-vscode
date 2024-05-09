package lab1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Task6 {
    public static void main(String[] args) {
        // Create an instance of TSPSolver
        TSPSolver tspSolver = new TSPSolver();

        // Define the distances between cities
        int[][] distances = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        // Solve the TSP problem
        List<Integer> tour = tspSolver.solveTSP(distances);

        // Print the tour
        System.out.println("Tour: " + tour);
    }

    public static class TSPSolver {
        // Method to solve the TSP using the Nearest Neighbor Algorithm
        public List<Integer> solveTSP(int[][] distances) {
            List<Integer> tour = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            // Start from city 0
            int currentCity = 0;
            tour.add(currentCity);
            visited.add(currentCity);
            while (visited.size() < distances.length) {
                int nextCity = findNearestNeighbor(currentCity, visited, distances);
                tour.add(nextCity);
                visited.add(nextCity);
                currentCity = nextCity;
                System.out.println("Next city: " + nextCity);
            }
            // Return to the starting city
            tour.add(0);
            return tour;
        }

        // Method to find the nearest unvisited neighbor of a given city
        private int findNearestNeighbor(int currentCity, Set<Integer> visited, int[][] distances) {
            int nearestNeighbor = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int city = 0; city < distances.length; city++) {
                if (!visited.contains(city) && distances[currentCity][city] < minDistance) {
                    nearestNeighbor = city;
                    minDistance = distances[currentCity][city];
                }
            }
            return nearestNeighbor;
        }
    }
}
