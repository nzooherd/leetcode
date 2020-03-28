type Node struct {
	val  int
	next *Node
}
type MyLinkedList struct {
	head *Node
	tail *Node
	size int
}

/** Initialize your data structure here. */
func Constructor() MyLinkedList {
	var myLinkedList *MyLinkedList = new(MyLinkedList)
	return *myLinkedList
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
func (this *MyLinkedList) Get(index int) int {
	if this.size <= index {
		return -1
	}
	var p *Node = this.head
	for i := 0; i < index; i++ {
		p = p.next
	}
	return p.val
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (this *MyLinkedList) AddAtHead(val int) {
	if this.head == nil {
		this.head = &Node{val, nil}
		this.tail = this.head
	} else {
		p := &Node{val, this.head}
		this.head = p
	}
	if this.tail.next != nil {
		this.tail = this.tail.next
	}
	this.size++
}

/** Append a node of value val to the last element of the linked list. */
func (this *MyLinkedList) AddAtTail(val int) {
	if this.tail == nil {
		this.AddAtHead(val)
	} else {
		this.tail.next = &Node{val, nil}
		this.tail = this.tail.next
	}
	this.size++
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index < 0 || index > this.size {
		return
	}
	if index == 0 {
		this.AddAtHead(val)
	} else if index == this.size {
		this.AddAtTail(val)
	} else {
		p := this.head
		for i := 0; i < index-1; i++ {
			p = p.next
		}
		node := &Node{val, p.next}
		p.next = node
        this.size++
	}

}

/** Delete the index-th node in the linked list, if the index is valid. */
func (this *MyLinkedList) DeleteAtIndex(index int) {
	if this.size > index {
		if index == 0 {
			this.head = this.head.next
			if this.size == 1 {
				this.tail = nil
			}
		} else {
			node := this.head
			for i := 0; i < index-1; i++ {
				node = node.next
			}
			if this.tail == node.next {
				this.tail = node
				this.tail.next = nil
			} else {
				node.next = node.next.next
			}
		}
		this.size--
	}
}
