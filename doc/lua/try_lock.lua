redis.replicate_commands()
local result = redis.call('setnx', KEYS[1], ARGV[1])
if (result == 1) then
    result = redis.call('pexpire', KEYS[1], ARGV[2])
end
return result
