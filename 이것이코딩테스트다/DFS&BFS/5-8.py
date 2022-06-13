'''
dfs 메서드 예제
'''
def dfs(graph, v, visited):
    # 현재 노드 방문 처리
    visited[v] = True
    # 방문한 노드 출력
    print(v, end = " ")
    
    # for문을 통해 현재 노드와 연결된 노드 순회
    for i in graph[v]:
        # 연결 노드 중 방문하지 않은 노드일 시
        if not visited[i]:
            # dfs 반복
            dfs(graph, i, visited)

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9

# 정의된 DFS 함수 호출
dfs(graph, 1, visited)