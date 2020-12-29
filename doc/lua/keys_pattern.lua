redis.replicate_commands()
local result = {}
local scanResultIndex = 0
while scanResultIndex ~= '0' do
    local idx = tonumber(scanResultIndex)
    local scanResult = redis.call('scan', idx, 'match', KEYS[1])
    local scanResultTable = scanResult[2]
    for k, v in pairs(scanResultTable) do
        table.insert(result, v)
    end
    scanResultIndex = scanResult[1]
end
return result
