import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])
        meet_end_times = []
        if len(intervals) <= 1:
            return len(intervals)
        result = 1
        heapq.heappush(meet_end_times, intervals[0][1])

        for i in range(1, len(intervals)):
            first_end_time = heapq.heappop(meet_end_times)
            if first_end_time <= intervals[i][0]:
                heapq.heappush(meet_end_times, intervals[i][1])
            else:
                heapq.heappush(meet_end_times, intervals[i][1])
                heapq.heappush(meet_end_times, first_end_time)
                result += 1

        return result