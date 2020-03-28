typedef struct {
    int top ;
    int capacity;
    int *nums;  
    int *min;
} MinStack;

/** initialize your data structure here. */
MinStack* minStackCreate(int maxSize) {
    MinStack* stack = (MinStack *)malloc(sizeof(MinStack));
    stack->capacity = 10000;
    stack->top = 0;
    stack->nums = (int *)malloc(sizeof(int) * (stack->capacity));
    stack->min = (int*)malloc(sizeof(int) * (stack -> capacity));
    return stack;
}

void minStackPush(MinStack* obj, int x) {
    if(obj->top < obj->capacity) ;
    else {
        int *nums_creat = obj->nums + obj->capacity;
        nums_creat = (int*)malloc(sizeof(int) * 10);
        int *min_creat = obj->min + obj->capacity;
        min_creat = (int*)malloc(sizeof(int) * 10);
    }
    obj->nums[obj->top] = x;
    if(obj->top == 0 || x < obj->min[obj->top-1]) obj->min[obj->top] = x;
    else obj->min[obj->top] = obj->min[obj->top-1];
    obj->top++;
}

void minStackPop(MinStack* obj) {
    obj->top--;
}

int minStackTop(MinStack* obj) {
   return obj->nums[obj->top-1]; 
}

int minStackGetMin(MinStack* obj) {
    return obj->min[obj->top-1];
}

void minStackFree(MinStack* obj) {
    free(obj);  
}

/**
 * Your MinStack struct will be instantiated and called as such:
 * struct MinStack* obj = minStackCreate(maxSize);
 * minStackPush(obj, x);
 * minStackPop(obj);
 * int param_3 = minStackTop(obj);
 * int param_4 = minStackGetMin(obj);
 * minStackFree(obj);
 */