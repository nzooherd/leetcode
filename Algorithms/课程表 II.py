class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        course2needs = [set() for _ in range(numCourses)]
        for requist in prerequisites:
            course2needs[requist[0]].add(requist[1])

        result = []
        has_finish = set()
        finish_course = 0
        while(finish_course < numCourses):
            for i, need_courses in enumerate(course2needs):
                if not (need_courses - has_finish) and i not in has_finish:
                    finish_course += 1
                    result.append(i)
                    has_finish.add(i)
                    break
            else:
                return []
        return result