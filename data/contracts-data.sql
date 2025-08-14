-- Contracts data for Witcher Microservices
-- Insert sample contracts

INSERT INTO contracts (monster_id, status, created_at, updated_at) VALUES
(1, 'PENDING', NOW(), NOW()),
(2, 'ACCEPTED', NOW(), NOW()),
(3, 'IN_PROGRESS', NOW(), NOW()),
(4, 'COMPLETED', NOW(), NOW()),
(5, 'PENDING', NOW(), NOW());

-- Insert contract items (required items for each contract)
INSERT INTO contract_items (contract_id, item_id) VALUES
-- Contract 1 requires items 1, 2, 3
(1, 1),
(1, 2),
(1, 3),
-- Contract 2 requires items 4, 5
(2, 4),
(2, 5),
-- Contract 3 requires items 1, 6
(3, 1),
(3, 6),
-- Contract 4 requires items 2, 7, 8
(4, 2),
(4, 7),
(4, 8),
-- Contract 5 requires items 3, 9
(5, 3),
(5, 9);