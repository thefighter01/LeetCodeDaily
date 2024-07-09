/**
 * @param {number[][]} customers
 * @return {number}
 */
var averageWaitingTime = function(customers) {
    let ans = 0;
    const sz = customers.length;

        let st = 0;
        for (const [first , second] of customers){
            st = Math.max(st , first);
            const end = st + second;
            ans+= end - first;
            st = end;
        }

        return ans / sz;
};
