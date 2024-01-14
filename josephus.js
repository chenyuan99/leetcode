//JavaScript dead easy solution

const josephus = (N, K) => {
    let res = 0;
    for (let i = 1; i <= N; ++i) res = (res + K) % i;
    return res + 1;
};

    // https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1152474/Josephus-Problem