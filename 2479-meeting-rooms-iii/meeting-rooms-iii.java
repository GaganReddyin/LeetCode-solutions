class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        // Map to keep track of the number of times each room has been booked
        Map<Integer, Integer> booked = new HashMap<>();
        
        // Priority queue to manage rooms by their end time
        PriorityQueue<Room> pq = new PriorityQueue<>(new Comparator<Room>() {
            public int compare(Room a, Room b) {
                if (a.end == b.end) {
                    return Integer.compare(a.id, b.id); // room id in ascending order
                }
                return Long.compare(a.end, b.end); // end time in ascending order
            }
        });
        
        // Min-heap to manage free rooms
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        
        // Initialize freeRooms with all room ids
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }
        
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));
        
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            
            // Free up rooms that have finished their meetings
            while (!pq.isEmpty() && pq.peek().end <= start) {
                freeRooms.add(pq.poll().id);
            }
            
            if (!freeRooms.isEmpty()) {
                // Assign a free room
                int roomId = freeRooms.poll();
                booked.put(roomId, booked.getOrDefault(roomId, 0) + 1);
                pq.add(new Room(end, roomId));
            } else {
                // No free rooms, find the room with the earliest end time
                Room room = pq.poll();
                booked.put(room.id, booked.getOrDefault(room.id, 0) + 1);
                pq.add(new Room(room.end + (end - start), room.id));
            }
        }
        
        // Find the room with the maximum number of bookings
        int maxBookings = 0;
        int meetingRoom = -1;
        for (Map.Entry<Integer, Integer> entry : booked.entrySet()) {
            if (entry.getValue() > maxBookings) {
                maxBookings = entry.getValue();
                meetingRoom = entry.getKey();
            }
        }
        
        return meetingRoom;
    }
    
    class Room {
        long end;
        int id;
        
        Room(long end, int id) {
            this.end = end;
            this.id = id;
        }
    }
}