class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        graph = defaultdict(list)
        indgree = defaultdict(int)
        for idx, recipe in enumerate(recipes):
            for ingredient in ingredients[idx]:
                graph[ingredient].append(recipe)
                indgree[recipe]+=1
        
        queue = deque()
        output = []

        for supply in supplies:
            if supply in graph:
                queue.append(supply)

        while queue:
            top = queue.popleft()
            for ingredient in graph[top]:
                indgree[ingredient]-=1
                if indgree[ingredient] == 0:
                    queue.append(ingredient)
                    if ingredient not in supplies:
                        supplies.append(ingredient)
                        output.append(ingredient)
   
        return output